package pl.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.elearning.model.User;
import pl.elearning.services.ArticleService;
import pl.elearning.services.CourseService;
import pl.elearning.services.RoleService;
import pl.elearning.services.UserService;
import pl.elearning.services.CategoriesService;

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

    @RequestMapping("/user/edit/{Id}")
    public ModelAndView showEditUserForm(@PathVariable(name = "Id") Long id) {
        ModelAndView mav = new ModelAndView("admin/edit-user");
        User user = userService.get(id);
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping("/users/delete/{Id}")
    public String deleteUser(@PathVariable(name = "Id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }


}

