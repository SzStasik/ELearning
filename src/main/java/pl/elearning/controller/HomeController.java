package pl.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.elearning.model.User;
import pl.elearning.services.UserService;

@Controller
public class HomeController {

    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")

    public String home(Model model) {
        model.addAttribute("mmm", "testowane");
        return "home/start";
    }

    @GetMapping("/about")
    @ResponseBody
    public String about() {
        return "Here you can find some details for logged users";
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "admin/register";
    }

    @PostMapping("/register")
    public String afterRegister(User user, Model model) {
        userService.saveUser(user);
        return "redirect:/admin/login";
    }
}