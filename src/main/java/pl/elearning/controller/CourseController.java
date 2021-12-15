package pl.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.elearning.services.CourseService;

@Controller
public class CourseController {
    private CourseService courseService;

    @GetMapping("/course/Java")
    public String display(){
        return "/categories/categories";
    }
}
