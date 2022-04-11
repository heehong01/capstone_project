package com.example.backend_capstone.jpa.controller;


import com.example.backend_capstone.jpa.enititymodels.Garden;
import com.example.backend_capstone.jpa.enititymodels.User;
import com.example.backend_capstone.jpa.service.GardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class GardenController {
    private GardenService gardenService;

    @Autowired
    public GardenController(GardenService gardenService){
        this.gardenService = gardenService;
    }

    @PostMapping("/create_garden/newGarden")
    public String saveEmployee(@ModelAttribute("garden") @Valid Garden garden,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "html/CreateGarden";
        }

        // save employee to database
        gardenService.saveGarden(garden);
        return "redirect:/GardenList";
    }

    @GetMapping("/GardenList")
    public String getAllEmployees(Model model) {
        model.addAttribute("listGarden", gardenService.getAllGardens());
        return "html/GardenList";
    }

}
