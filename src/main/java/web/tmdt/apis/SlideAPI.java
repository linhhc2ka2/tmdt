package web.tmdt.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import web.tmdt.models.Slider;
import web.tmdt.services.SlideService;

@CrossOrigin
@RestController
public class SlideAPI {
    @Autowired
    SlideService slideService;

    @GetMapping("/api/slides/all")
    public List<Slider> getAllSlides() {
        return slideService.getAllSlides();
    }
}
