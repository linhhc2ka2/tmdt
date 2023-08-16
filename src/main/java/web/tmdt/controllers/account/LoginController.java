package web.tmdt.controllers.account;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import web.tmdt.configs.*;
import web.tmdt.interfaces.UserRepository;
import web.tmdt.models.User;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/account")
public class LoginController {
    @Autowired
    HttpServletRequest httpServletRequest;
    @Autowired
    UserRepository userRepository;
    @Autowired
    SessionConfig sessionConfig;
    @Autowired
    CookieConfig cookieConfig;
    @Autowired
    MailConfig mailConfig;

    @GetMapping(value = "/login")
    public String viewLoginPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userNameCurrent", sessionConfig.get("userName"));

        return "pages/login/index";
    }

    @PostMapping(value = "/login")
    public String handleLogin(Model model, @RequestParam("email") String email,
            @RequestParam("password") String password) {
        User user = userRepository.findByUserEmail(email);
        model.addAttribute("user", user);

        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            sessionConfig.set("userName", user.getFirstName());
            cookieConfig.add("email", email, true ? 24 : 0);

            return "redirect:/homepage";
        } else {
            model.addAttribute("error", "Đăng nhập thất bại *");
            return "pages/login/index";
        }
    }

    @RequestMapping(value = "/logout")
    public String handleLogout(Model model) {
        sessionConfig.invalidate();

        return "redirect:/account/login";
    }

    @PostMapping(value = "/forgot-password")
    public String handleForgotPassword(Model model, @RequestParam("email") String email) {

        User user = userRepository.findByUserEmail(email);

        if (user.getEmail().equals(email)) {
            try {
                mailConfig.send(email, "[No-reply] Mật khẩu của bạn",
                        "Đây là mật khẩu của bạn: " + user.getPassword());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "redirect:/account/login";
    }

}
