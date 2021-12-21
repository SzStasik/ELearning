package pl.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.elearning.model.Categories;
import pl.elearning.model.Course;
import pl.elearning.services.CategoriesService;
import pl.elearning.services.CourseService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CategoriesController {

    private final CategoriesService categoriesService;
    private final CourseService courseService;

    public CategoriesController(CategoriesService categoriesService, CourseService courseService) {
        this.categoriesService = categoriesService;
        this.courseService = courseService;
    }

    @GetMapping("/categories")
    public String viewCourse(Model model) {
        List<Categories> listCategories = categoriesService.listAll();
        model.addAttribute("categories", listCategories);
        return "categories/view-categories";
    }

    @GetMapping("/categories/add")
    public String showNewCategoriesForm(Model model) {
        Categories categories = new Categories();
        model.addAttribute("categories", categories);
        return "categories/add-categories";
    }

    @PostMapping("/categories/add")
    public String saveCategories(@ModelAttribute("categories") Categories categories) {
        categoriesService.save(categories);
        return "redirect:/categories";
    }

    @GetMapping("/categories/edit/{Id}")
    public String update(Model model, @PathVariable long Id) {
        model.addAttribute("categories", categoriesService.get(Id));
        return "categories/edit-categories";
    }

    @PostMapping("/categories/edit/{Id}")
    public String processUpdate(@Valid Categories categories, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "categories/edit-categories";
        }
        categoriesService.save(categories);
        return "redirect:/categories";
    }

    @RequestMapping("/categories/delete/{Id}")
    public String deleteCategories(@PathVariable(name = "Id") Long id) {
        categoriesService.delete(id);
        return "redirect:/categories";
    }
}