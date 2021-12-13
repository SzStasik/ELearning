package pl.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import pl.elearning.model.Course;
import pl.elearning.services.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/viewCourse")
    @ResponseBody
    public String viewCourse(Model model) {
        model.addAttribute("course", courseService.getCourse());
        return "course";
    }

    @GetMapping("/addCourse")
    public String addCourseView(Model model) {
        model.addAttribute("course", new Course());
        return "add-course";
    }

    @PostMapping("/addCourse")
    public RedirectView addCourse(@ModelAttribute("course") Course course, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/course/addCourse", true);
        Course saveCourse = courseService.addCourse(course);
        redirectAttributes.addFlashAttribute("saveCourse", saveCourse);
        redirectAttributes.addFlashAttribute("addCourseSuccess", true);
        return redirectView;
    }
}
