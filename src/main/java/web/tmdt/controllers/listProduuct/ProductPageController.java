package web.tmdt.controllers.listProduuct;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import web.tmdt.services.ProductService;

@Controller
@RequestMapping("/san-pham")
public class ProductPageController {

    // private final ProductService productService;

    // @Autowired
    // public ProductPageController(ProductService productService) {
    // this.productService = productService;
    // }

    @GetMapping
    public String viewProductPage(
            @RequestParam("categoryid") Integer categoryid) {
        return "/pages/list-product/index";
    }

    // Xử lý các yêu cầu HTTP bằng cách gọi các phương thức của productService

}
