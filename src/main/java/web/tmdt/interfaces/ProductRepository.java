package web.tmdt.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.*;

import web.tmdt.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Spring Data JPA

    // Load all products by categoryid
    @Query("SELECT o FROM Product o WHERE o.category.id = ?1")
    List<Product> findAllByCategoryId(Integer categoryid);

}
