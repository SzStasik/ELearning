package pl.elearning.services;

import org.springframework.stereotype.Service;
import pl.elearning.model.Categories;
import pl.elearning.repositories.CategoriesRepository;

import java.util.Collection;
@Service
public class CategoriesServiceImpl implements CategoriesService {
    private final CategoriesRepository categoriesRepository;

    public CategoriesServiceImpl(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public Collection<Categories> getCategories() {
        return categoriesRepository.findAll();
    }

    @Override
    public Categories addCategories(Categories categories) {
        return null;
    }
}
