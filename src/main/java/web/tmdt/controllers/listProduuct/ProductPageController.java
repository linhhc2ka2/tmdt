package web.tmdt.controllers.listProduuct;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import web.tmdt.services.ProductService;

@Controller
@RequestMapping("/san-pham")
public class ProductPageController {
    @GetMapping
    public String viewProductPage(
            @RequestParam("categoryid") Integer categoryid) {
        return "/pages/client/list-product/index";
    }

}
