package pl.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.elearning.model.Categories;
import pl.elearning.servicesImpl.CategoriesServiceImpl;

import java.util.List;

@Controller
public class CategoriesController {

    private final CategoriesServiceImpl categoriesServiceImpl;

    public CategoriesController(CategoriesServiceImpl categoriesServiceImpl) {
        this.categoriesServiceImpl = categoriesServiceImpl;
    }

    @GetMapping("/categories")
    public String viewCourse(Model model) {
        List<Categories> listCategories = categoriesServiceImpl.listAll();
        model.addAttribute("listCategories", listCategories);
        return "categories/view-categories";
    }

    @GetMapping("/new")
    public String showNewCategoriesForm(Model model) {
        Categories categories = new Categories();
        model.addAttribute("categories", categories);
        return "categories/add-categories";
    }

    @PostMapping("/save")
    public String saveCategories(@ModelAttribute("categories") Categories categories) {
        categoriesServiceImpl.save(categories);
        return "redirect:/categories/view-categories";
    }

    @RequestMapping("/edit/{Id}")
    public ModelAndView shotEditCategoriesForm(@PathVariable(name = "Id") Long id) {
        ModelAndView mav = new ModelAndView("categories/edit-categories");
        Categories categories = categoriesServiceImpl.get(id);
        mav.addObject("categories", categories);

        return mav;

    }
    @RequestMapping("/delete/{Id}")
    public String deleteCategories(@PathVariable(name = "Id") Long id) {
     categoriesServiceImpl.delete(id);
        return "redirect:/categories/view-categories";
    }
}