package pl.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.elearning.model.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class ValidationController {
    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate")
    public String validate(Model model) {
        User user = new User();
        Set<ConstraintViolation<User>> validate = validator.validate(user);
        List<String> stringList = new ArrayList<>();
        for (ConstraintViolation<User> userConstraintViolation : validate) {
            stringList.add(userConstraintViolation.getPropertyPath() + " : " + userConstraintViolation.getMessage());
        }
        model.addAttribute("validateErrors", stringList);
        return "validate/test";
    }

}
