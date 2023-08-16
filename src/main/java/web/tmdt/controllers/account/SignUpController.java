package web.tmdt.controllers.account;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import web.tmdt.interfaces.UserRepository;
import web.tmdt.models.User;

@Controller
@RequestMapping("/account")
public class SignUpController {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/sign-up")
    public String viewSignUp(Model model) {
        model.addAttribute("userNew", new User());

        return "pages/sign-up/index";
    }

    @PostMapping(value = "/sign-up")
    public String postMethodName(Model model, @ModelAttribute Optional<User> user,
            @RequestParam("confirmPassword") String confirmPassword) {
        model.addAttribute("userNew", new User());

        if (user.isPresent()) {
            if (user.get().getPassword().equals(confirmPassword)) {
                model.addAttribute("message", "Thanh cong");
                userRepository.save(user.get());
            } else {
                model.addAttribute("error", "Không trùng mật khẩu và mật khẩu xác nhận!");
            }

        } else {
            model.addAttribute("error", "Chua dien");
        }

        return "pages/sign-up/index";
    }

}
