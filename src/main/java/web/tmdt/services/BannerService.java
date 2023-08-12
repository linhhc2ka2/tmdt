package web.tmdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.tmdt.interfaces.BannerRepository;
import web.tmdt.models.Banner;

@Service
public class BannerService {
    private final BannerRepository bannerRepository;

    @Autowired
    public BannerService(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    // Load all banners
    public List<Banner> getAllBanners() {
        return this.bannerRepository.findAll();
    }
}
