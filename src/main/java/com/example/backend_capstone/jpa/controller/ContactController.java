package com.example.backend_capstone.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String showContactUsPage(){
        return "html/Contact";
    }
}
