package web.tmdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.tmdt.interfaces.SlideRepository;
import web.tmdt.models.Slider;

@Service
public class SlideService {
    private final SlideRepository slideRepository;

    @Autowired
    public SlideService(SlideRepository slideRepository) {
        this.slideRepository = slideRepository;
    }

    // Load all slides
    public List<Slider> getAllSlides() {
        return this.slideRepository.findAll();
    }
}
