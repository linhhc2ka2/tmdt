package web.tmdt.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import web.tmdt.models.Banner;
import web.tmdt.services.BannerService;

@CrossOrigin
@RestController
public class BannerAPI {
    @Autowired
    BannerService bannerService;

    @GetMapping("/api/banners/all")
    public List<Banner> getAllBanners() {
        return bannerService.getAllBanners();
    }
}
