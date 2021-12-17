package pl.elearning.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.elearning.model.Categories;
import pl.elearning.repositories.CategoriesRepository;

import java.util.Collection;
import java.util.List;

@Service
public class CategoriesServiceImpl {
    @Autowired

    private CategoriesRepository categoriesRepository;

    public CategoriesServiceImpl(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }


    public List<Categories> listAll()  {
        return categoriesRepository.findAll();
    }


    public void save(Categories categories) {
         categoriesRepository.save(categories);
    }


    public Categories get(Long Id) {
        return categoriesRepository.findById(Id).get();
    }


    public void delete(Long Id) {
        categoriesRepository.deleteById(Id);
    }


}
