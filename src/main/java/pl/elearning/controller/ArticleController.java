package pl.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.elearning.model.Article;
import pl.elearning.services.ArticleService;

import javax.validation.Valid;
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

    @GetMapping("/article/edit/{Id}")
  public String update(Model model, @PathVariable long Id){
        model.addAttribute("article", articleService.get(Id));
        return "article/edit-article";
    }
    @PostMapping("/article/edit/{Id}")
    public String processUpdate(@Valid Article article, BindingResult result, Model model){
        if(result.hasErrors()){
            return "article/edit-article";
        }
        articleService.save(article);
        return "redirect:/article";
    }


    @RequestMapping("/article/delete/{id}")
    public String deleteArticle(@PathVariable(name = "id") Long id){
        articleService.delete(id);
        return "redirect:/article";
    }
}
