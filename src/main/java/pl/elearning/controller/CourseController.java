package pl.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import pl.elearning.model.Course;
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
    @GetMapping("/addcourse")
    public String addCourseView(Model model){
        model.addAttribute("course", new Course());
        return "add-course";
    }

    @PostMapping("/addcourse")
    public RedirectView addCourse(@ModelAttribute("course")Course course, RedirectAttributes redirectAttributes){
        final RedirectView redirectView = new RedirectView("/course/addcourse", true);
        Course savedCourse = courseService.addCourse(course);
        redirectAttributes.addFlashAttribute("savedCourse", savedCourse);
        redirectAttributes.addFlashAttribute("addCourseSuccess", true);
        return redirectView;
    }

    @GetMapping("/course/Java")
    public String display(){
        return "/categories/categories";
    }


}
