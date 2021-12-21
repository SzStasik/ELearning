package pl.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.elearning.model.Course;
import pl.elearning.services.CourseService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/course")
    public String viewCourse(Model model) {
        List<Course> listCourse = courseService.listAll();
        model.addAttribute("course", listCourse);
        return "course/view-course";
    }

    @GetMapping("/course/add")
    public String showNewCourseForm(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "course/add-course";
    }

    @PostMapping("/course/add")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.save(course);
        return "redirect:/course";
    }

    @GetMapping("/course/edit/{Id}")
    public String update(Model model, @PathVariable long Id) {
        model.addAttribute("course", courseService.getCourse(Id));
        return "course/edit-course";
    }

    @PostMapping("/course/edit/{Id}")
    public String processUpdate(@Valid Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "course/edit-course";
        }
        courseService.save(course);
        return "redirect:/course";
    }

    @RequestMapping("/course/delete/{id}")
    public String deleteCourse(@PathVariable(name = "id") Long id) {
        courseService.delete(id);
        return "redirect:/course";
    }
}
