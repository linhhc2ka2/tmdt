package web.tmdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.tmdt.interfaces.CouponRepository;
import web.tmdt.models.Coupon;

@Service
public class CouponService {
    private final CouponRepository couponRepository;

    @Autowired
    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    // Load all coupons
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }
}
