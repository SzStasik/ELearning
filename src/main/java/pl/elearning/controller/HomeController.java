package pl.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.elearning.model.User;
import pl.elearning.services.UserService;

@Controller
public class HomeController {

    @RequestMapping("/")

    public String home(Model model) {
        model.addAttribute("user", new User());
        return "home/start";
    }
}