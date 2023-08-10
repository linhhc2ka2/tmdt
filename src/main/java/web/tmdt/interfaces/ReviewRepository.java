package web.tmdt.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import web.tmdt.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
