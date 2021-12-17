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

    @GetMapping("/view")
    public String viewCourse(Model model){
        model.addAttribute("course", courseService.getCourse());
        return "course/view-course";
    }
    @GetMapping("/add")
    public String addCourseView(Model model){
        model.addAttribute("course", new Course());
        return "course/add-course";
    }

    @PostMapping("/add")
    public RedirectView addCourse(@ModelAttribute("course")Course course, RedirectAttributes redirectAttributes){
        final RedirectView redirectView = new RedirectView("/course/view", true);
        Course savedCourse = courseService.addCourse(course);
        redirectAttributes.addFlashAttribute("savedCourse", savedCourse);
        redirectAttributes.addFlashAttribute("addCourseSuccess", true);
        return redirectView;
    }

}
