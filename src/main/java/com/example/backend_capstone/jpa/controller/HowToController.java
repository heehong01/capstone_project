package com.example.backend_capstone.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HowToController {

    @GetMapping("/garden/how_to_germinate_seeds")
    public String showGerminateSeedPage(){
        return "html/howToStartPlanting";
    }

}
