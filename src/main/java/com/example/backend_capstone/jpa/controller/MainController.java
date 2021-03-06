package com.example.backend_capstone.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String showHomePage(){
        return "index";
    }

    @GetMapping("/main")
    public String showMainPage(){
        return "html/MainPage";
    }

    @GetMapping("/about_us")
    public String showAboutUsPage(){
        return "html/AboutUs";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }

    @GetMapping("/garden/how_to_germinate_seeds")
    public String showGerminateSeedPage(){
        return "html/howToStartPlanting";
    }

    @GetMapping("/contact")
    public String showContactUsPage(){
        return "html/Contact";
    }
}

