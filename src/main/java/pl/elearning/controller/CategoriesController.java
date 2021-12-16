package pl.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.elearning.services.CategoriesService;

@Controller
@RequestMapping("/categories")
public class CategoriesController {
    private CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping("/1")
    public String viewCourse(Model model) {
        model.addAttribute("categories", categoriesService.getCategories());
        return "categories/view-categories";
    }
}