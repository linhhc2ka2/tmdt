package web.tmdt.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import web.tmdt.models.Slider;

public interface SlideRepository extends JpaRepository<Slider, Integer> {

}
