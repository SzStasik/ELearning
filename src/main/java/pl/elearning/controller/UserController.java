package pl.elearning.controller;

import org.springframework.stereotype.Controller;
import pl.elearning.services.UserService;

@Controller
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
}
