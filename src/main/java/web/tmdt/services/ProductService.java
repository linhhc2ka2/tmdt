package web.tmdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.tmdt.interfaces.ProductRepository;
import web.tmdt.models.Product;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Load all products
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    // Load products by categoryid
    public List<Product> getAllProductsByCategoryId(Integer categoryid) {
        return this.productRepository.findAllByCategoryId(categoryid);
    }

    // Load flashsale when sale > 0
    public List<Product> getAllProductsFlashsale() {
        return this.productRepository.findAllFlashsale();
    }
}
