package web.tmdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.tmdt.interfaces.CategoryRepository;
import web.tmdt.models.Category;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    };

    // Get all Categories
    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }
}
