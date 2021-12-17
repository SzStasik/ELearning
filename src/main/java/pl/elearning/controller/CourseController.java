package pl.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.elearning.model.Course;
import pl.elearning.services.CourseService;

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
    public String saveCourse(@ModelAttribute("course") Course course){
        courseService.save(course);
        return "redirect:/course";
    }
    @RequestMapping("/course/edit/{Id}")
    public ModelAndView showEditCourseForm(@PathVariable(name = "Id") Long id){
        ModelAndView mav = new ModelAndView("course/edit-course");
        Course course = courseService.getCourse(id);
        mav.addObject("course", course);
        return mav;
    }

    @RequestMapping("/course/delete/{id}")
    public String deleteCourse(@PathVariable(name = "id") Long id){
        courseService.delete(id);
        return "redirect:/course";
    }
}
