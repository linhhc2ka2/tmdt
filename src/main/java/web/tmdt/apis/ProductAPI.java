package web.tmdt.apis;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import web.tmdt.models.Product;
import web.tmdt.services.ProductService;

@CrossOrigin("*")
@RestController
public class ProductAPI {
    @Autowired
    ProductService productService;

    @GetMapping("/api/products/all")
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/api/products/{categoryid}")
    public List<Product> getAllProductsByCategoryId(@PathVariable("categoryid") Integer categoryid) {
        return productService.getAllProductsByCategoryId(categoryid);
    }

    @GetMapping("/api/products/flash-sale")
    public List<Product> getAllProductsFlashsale() {
        return productService.getAllProductsFlashsale();
    }

}
