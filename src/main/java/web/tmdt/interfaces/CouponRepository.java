package web.tmdt.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import web.tmdt.models.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

}
