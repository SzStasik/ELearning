package pl.elearning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.elearning.model.Categories;


public interface CategoriesRepository extends JpaRepository<Categories, Long> {
}
