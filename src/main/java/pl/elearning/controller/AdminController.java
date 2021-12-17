package pl.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.elearning.services.ArticleService;
import pl.elearning.services.CourseService;
import pl.elearning.services.RoleService;
import pl.elearning.services.UserService;
import pl.elearning.servicesImpl.CategoriesService;

@Controller

public class AdminController {

    private final UserService userService;
    private final RoleService roleService;
    private final CourseService courseService;
    private final CategoriesService categoriesService;
    private final ArticleService articleService;

    public AdminController(UserService userService, RoleService roleService, CourseService courseService, CategoriesService categoriesService, ArticleService articleService) {
        this.userService = userService;
        this.roleService = roleService;
        this.courseService = courseService;
        this.categoriesService = categoriesService;
        this.articleService = articleService;
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.findAll());
       model.addAttribute("adminRole", roleService.findByName("ROLE_ADMIN"));
        return "/admin/user-list";
    }
    @RequestMapping("/users/delete/{Id}")
    public String deleteUser(@PathVariable(name = "Id") Long id) {
        userService.delete(id);
        return "redirect:/users";
}


}

