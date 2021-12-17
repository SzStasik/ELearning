package pl.elearning.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.elearning.model.Article;
import pl.elearning.repositories.ArticleRepository;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> listAll(){
        return articleRepository.findAll();
    }
    public void save(Article article){
        articleRepository.save(article);
    }
    public Article get(Long id){
        return articleRepository.findById(id).get();
    }
    public void delete(Long id){
     articleRepository.deleteById(id);
    }
}
