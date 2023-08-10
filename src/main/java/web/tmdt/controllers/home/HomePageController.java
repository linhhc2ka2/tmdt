package web.tmdt.controllers.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homepage")
public class HomePageController {
    @RequestMapping
    public String viewHomePage() {
        return "pages/home/index";
    }
}
