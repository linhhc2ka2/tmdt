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
        User user2 = userRepository.findByUserEmail(user.get().getEmail());

        if (user.isPresent()) {
            if (user2 == null || !user2.getEmail().equals(user.get().getEmail())) {
                if (user.get().getPassword().equals(confirmPassword)) {
                    if (user.get().getPassword().length() >= 3) {
                        userRepository.save(user.get());
                        model.addAttribute("message", "Đăng ký tài khoản thành công!");
                        model.addAttribute("userNew", new User());
                    } else {
                        model.addAttribute("error", "Mật khẩu phải từ 3 ký tự trở lên *");
                        model.addAttribute("userNew", user);
                    }
                } else {
                    model.addAttribute("error", "Mật khẩu của bạn chưa trùng khớp *");
                    model.addAttribute("userNew", user);
                }
            } else {
                model.addAttribute("error", "Email đã được đăng ký *");
                model.addAttribute("userNew", user);
            }
        } else {
            model.addAttribute("error", "Không nên bỏ trống *");
            model.addAttribute("userNew", user);
        }

        return "pages/sign-up/index";
    }

}
