package pl.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.elearning.model.Article;
import pl.elearning.services.ArticleService;

import java.util.List;

@Controller
public class ArticleController {

    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/article")
    public String viewArticle(Model model) {
        List<Article> listArticle = articleService.listAll();
        model.addAttribute("article", listArticle);
        return "article/view-article";
    }

    @GetMapping("/article/add")
    public String ShowNewArticleForm(Model model) {
        Article article = new Article();
        model.addAttribute("article", article);
        return "article/add-article";
    }

    @PostMapping("/article/add")
    public String saveArticle(@ModelAttribute("artcile") Article article) {
        articleService.save(article);
        return "redirect:/article";
    }

    @RequestMapping("/article/edit/{Id}")
    public ModelAndView showEditArticleForm(@PathVariable(name = "Id") Long id) {
        ModelAndView mav = new ModelAndView("article/edit-article");
        Article article = articleService.get(id);
        mav.addObject("article", article);
        return mav;
    }
    @RequestMapping("/article/delete/{id}")
    public String deleteArticle(@PathVariable(name = "id") Long id){
        articleService.delete(id);
        return "redirect:/article";
    }
}
