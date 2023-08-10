package web.tmdt.controllers.about;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gioi-thieu")
public class AboutController {
    @RequestMapping
    public String viewAboutPage() {
        return "/pages/about/index";
    }
}
