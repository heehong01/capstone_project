package com.example.backend_capstone.jpa.controller;


import com.example.backend_capstone.jpa.enititymodels.Garden;
import com.example.backend_capstone.jpa.enititymodels.GardenInfo;
import com.example.backend_capstone.jpa.enititymodels.Seeds;
import com.example.backend_capstone.jpa.service.GardenInfoService;
import com.example.backend_capstone.jpa.service.GardenService;
import com.example.backend_capstone.jpa.service.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller
public class GardenController {
    private GardenService gardenService;
    private SeedService seedService;
    private GardenInfoService gardenInfoService;

    @Autowired
    public GardenController(GardenService gardenService, SeedService seedService, GardenInfoService gardenInfoService){
        this.gardenService = gardenService;
        this.seedService = seedService;
        this.gardenInfoService = gardenInfoService;
    }




    @GetMapping("/create_garden")
    public String showCreateGardenPage(Model model){
        Garden garden = new Garden();
        model.addAttribute("garden", garden);
        model.addAttribute("seeds", seedService.getAllSeeds());
        model.addAttribute("gardenInfo", gardenInfoService.getAllGardenInfo());
        return "html/CreateGarden";
    }


    @PostMapping("/create_garden")
    public String saveGarden(@ModelAttribute("garden") @Valid Garden garden, @ModelAttribute("gardenInfo") GardenInfoSelectionDTO gardenInfo, @ModelAttribute("seeds") SeedSelectionDTO seeds, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "html/CreateGarden";
        }
        System.out.println(gardenInfo);
        System.out.println(garden);

        seeds.getIds().removeIf(Objects::isNull);
        List<Seeds> seedsList = seedService.getAllSeeds(seeds.getIds());
        garden.setSeedType(seedsList);
        gardenService.saveGarden(garden);
        return "redirect:/GardenList";
    }

    @GetMapping("/GardenList")
    public String getAllEmployees(Model model) {
        model.addAttribute("listGarden", gardenService.getAllGardens());
        return "html/GardenList";
    }

}
