package no.oslomet.oblig2_s315278.service;

import no.oslomet.oblig2_s315278.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();
    Category getCategory(String name);
    void addCategory(Category category);
    void deleteCategory(String name);

}
