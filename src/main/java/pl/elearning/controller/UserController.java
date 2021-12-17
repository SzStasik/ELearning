package pl.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.elearning.model.User;
import pl.elearning.services.UserService;

import javax.validation.Valid;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "admin/register";
    }

    @PostMapping("/register")
    public String afterRegister(@Valid @ModelAttribute User user, Model model) {
//        if (result.hasErrors()) {
//            return "admin/register";
//        } else {
            userService.saveUser(user);
            return "redirect:/admin/login";
        }
    }
//}
