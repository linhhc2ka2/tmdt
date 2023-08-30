package web.tmdt.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import web.tmdt.interfaces.UserRepository;
import web.tmdt.models.User;

@CrossOrigin
@RestController
public class UserAPI {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/api/user/{email}")
    public User getUserByEmail(@PathVariable("email") String email) {
        return userRepository.findByUserEmail(email);
    }
}
