package pl.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.elearning.model.User;
import pl.elearning.services.ArticleService;
import pl.elearning.services.CourseService;
import pl.elearning.services.RoleService;
import pl.elearning.services.UserService;
import pl.elearning.services.CategoriesService;

import javax.validation.Valid;
import javax.validation.Validator;

@Controller
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;
    private final CourseService courseService;
    private final CategoriesService categoriesService;
    private final ArticleService articleService;
    private final Validator validator;

    public AdminController(UserService userService, RoleService roleService, CourseService courseService, CategoriesService categoriesService, ArticleService articleService, Validator validator) {
        this.userService = userService;
        this.roleService = roleService;
        this.courseService = courseService;
        this.categoriesService = categoriesService;
        this.articleService = articleService;
        this.validator = validator;
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("adminRole", roleService.findByName("ROLE_ADMIN"));
        return "/admin/user-list";
    }

    @GetMapping("/users/add")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "admin/add-user";
    }

    @PostMapping("/users/add")
    public String saveUser(@ModelAttribute("user") User user){
    userService.saveUser(user);
    return "redirect:/users";
    }

    @GetMapping("/users/edit/{Id}")
    public String update(Model model, @PathVariable long Id) {
        model.addAttribute("user", userService.get(Id));
        return "admin/edit-user";
    }

    @PostMapping("/users/edit/{Id}")
    public String processUpdate(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin/edit-user";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }

    @RequestMapping("/users/delete/{Id}")
    public String deleteUser(@PathVariable(name = "Id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }


}

