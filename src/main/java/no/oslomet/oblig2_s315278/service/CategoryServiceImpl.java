package no.oslomet.oblig2_s315278.service;

import no.oslomet.oblig2_s315278.model.Category;
import no.oslomet.oblig2_s315278.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Transactional
    public Category getCategory(String name) {
        return categoryRepository.findById(name).get();
    }

    @Transactional
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Transactional
    public void deleteCategory(String name) {
        categoryRepository.deleteById(name);
    }
}
