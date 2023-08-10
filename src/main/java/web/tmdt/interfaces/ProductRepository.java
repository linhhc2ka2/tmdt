package web.tmdt.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import web.tmdt.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
