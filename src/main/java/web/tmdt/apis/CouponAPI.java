package web.tmdt.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import web.tmdt.models.Coupon;
import web.tmdt.services.CouponService;

@CrossOrigin
@RestController
public class CouponAPI {
    @Autowired
    CouponService couponService;

    @GetMapping("/api/coupons/all")
    public List<Coupon> getAllCoupons() {
        return couponService.getAllCoupons();
    }
}
