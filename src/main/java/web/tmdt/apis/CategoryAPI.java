package web.tmdt.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import web.tmdt.models.Category;
import web.tmdt.services.CategoryService;

@CrossOrigin
@RestController
public class CategoryAPI {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/api/categories/all")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
