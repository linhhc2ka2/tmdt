package web.tmdt.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import web.tmdt.models.Banner;

public interface BannerRepository extends JpaRepository<Banner, Integer> {

}
