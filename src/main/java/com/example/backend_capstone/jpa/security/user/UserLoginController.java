package com.example.backend_capstone.jpa.security.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLoginController {
    @GetMapping("/login")
    public String login(Model model) {
            return "html/LoginPage";
    }
}
