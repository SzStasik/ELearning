package pl.elearning.services;

import org.springframework.stereotype.Service;
import pl.elearning.model.Categories;

import java.util.Collection;

public interface CategoriesService {
    Collection<Categories> getCategories();

    Categories addCategories(Categories categories);
}
