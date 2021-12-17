package pl.elearning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.elearning.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
