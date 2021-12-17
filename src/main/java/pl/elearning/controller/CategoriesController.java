package pl.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.elearning.model.Categories;
import pl.elearning.servicesImpl.CategoriesService;

import java.util.List;

@Controller
public class CategoriesController {

    private final CategoriesService categoriesServiceImpl;

    public CategoriesController(CategoriesService categoriesServiceImpl) {
        this.categoriesServiceImpl = categoriesServiceImpl;
    }

    @GetMapping("/categories")
    public String viewCourse(Model model) {
        List<Categories> listCategories = categoriesServiceImpl.listAll();
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
        categoriesServiceImpl.save(categories);
        return "redirect:/categories";
    }

    @RequestMapping("/categories/edit/{Id}")
    public ModelAndView showEditCategoriesForm(@PathVariable(name = "Id") Long id) {
        ModelAndView mav = new ModelAndView("categories/edit-categories");
        Categories categories = categoriesServiceImpl.get(id);
        mav.addObject("categories", categories);

        return mav;

    }
    @RequestMapping("/categories/delete/{Id}")
    public String deleteCategories(@PathVariable(name = "Id") Long id) {
     categoriesServiceImpl.delete(id);
        return "redirect:/categories";
    }
}