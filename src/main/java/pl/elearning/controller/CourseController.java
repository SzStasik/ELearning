package pl.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.elearning.services.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/viewcourse")
    public String viewCourse(Model model){
        model.addAttribute("course", courseService.getCourse());
        return "view-course";
    }

    @GetMapping("/course/Java")
    public String display(){
        return "/categories/categories";
    }


}
