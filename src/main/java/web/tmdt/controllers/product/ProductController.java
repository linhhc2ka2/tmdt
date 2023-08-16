package web.tmdt.controllers.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import web.tmdt.configs.SessionConfig;

@Controller
@RequestMapping(value = "/list-products")
public class ProductController {
    @Autowired
    SessionConfig sessionConfig;

    @GetMapping()
    public String viewProductPage(Model model) {
        model.addAttribute("userNameCurrent", sessionConfig.get("userName"));

        return "pages/client/list-product/index";
    }
}
