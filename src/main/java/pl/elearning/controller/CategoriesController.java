package pl.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriesController {
    @GetMapping("/article/Tablice")
    public String display(){
        return "/article/Tablice";
    }
}
