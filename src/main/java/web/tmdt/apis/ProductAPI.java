package web.tmdt.apis;

import java.util.List;

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
}
