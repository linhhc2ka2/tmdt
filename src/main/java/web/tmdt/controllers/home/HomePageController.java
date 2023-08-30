package web.tmdt.controllers.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import web.tmdt.configs.SessionConfig;

@Controller
@RequestMapping(value = { "/", "/homepage" })
public class HomePageController {
    @Autowired
    SessionConfig sessionConfig;

    @RequestMapping
    public String viewHomePage(Model model) {
        model.addAttribute("userNameCurrent", sessionConfig.get("userName"));

        return "redirect:/client/layout.html";
    }
}
