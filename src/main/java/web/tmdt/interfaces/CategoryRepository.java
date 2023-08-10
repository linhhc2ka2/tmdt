package web.tmdt.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import web.tmdt.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
