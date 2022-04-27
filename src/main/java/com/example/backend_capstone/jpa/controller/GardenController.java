package com.example.backend_capstone.jpa.controller;


import com.example.backend_capstone.jpa.DTO.GardenInfoSelectionDTO;
import com.example.backend_capstone.jpa.DTO.HouseSelectionDTO;
import com.example.backend_capstone.jpa.DTO.SeedSelectionDTO;
import com.example.backend_capstone.jpa.enititymodels.*;
import com.example.backend_capstone.jpa.security.user.User;
import com.example.backend_capstone.jpa.security.user.UserService;
import com.example.backend_capstone.jpa.service.Client.ClientService;
import com.example.backend_capstone.jpa.service.GardenInfo.GardenInfoService;
import com.example.backend_capstone.jpa.service.Garden.GardenService;
import com.example.backend_capstone.jpa.service.House.HouseService;
import com.example.backend_capstone.jpa.service.Seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.*;

@Controller
public class GardenController {
    private GardenService gardenService;
    private SeedService seedService;
    private GardenInfoService gardenInfoService;
    private HouseService houseService;
    private UserService userService;
    private ClientService clientService;

    @Autowired
    public GardenController(GardenService gardenService, SeedService seedService, GardenInfoService gardenInfoService, HouseService houseService, UserService userService, ClientService clientService) {
        this.gardenService = gardenService;
        this.seedService = seedService;
        this.gardenInfoService = gardenInfoService;
        this.houseService = houseService;
        this.userService = userService;
        this.clientService = clientService;
    }


    @GetMapping("/create_garden")
    public String showCreateGardenPage(Model model){

        Garden garden = new Garden();
        model.addAttribute("garden", garden);
        model.addAttribute("seeds", seedService.getAllSeeds());
        model.addAttribute("gardenInfo", gardenInfoService.getAllGardenInfo());
        model.addAttribute("house", houseService.getAllHouse());
        return "html/CreateGarden";
    }


    @PostMapping("/create_garden")
    public String saveGarden(@ModelAttribute("garden") @Valid Garden garden,
                             @ModelAttribute("gardenInfo") GardenInfoSelectionDTO gardenInfo,
                             @ModelAttribute("seeds") SeedSelectionDTO seeds,
                             @ModelAttribute("house") HouseSelectionDTO house,
                             Principal principal,
                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "html/CreateGarden";
        }
        String email = principal.getName();
        User user = userService.findByEmail(email);
        Long userId = user.getId();
        Client client = clientService.getUserById(userId);

        Long id = house.getHouseId();
        House houseValue = houseService.getHouseById(house.getHouseId());
        garden.setHouseType(houseValue);


        GardenInfo gardenTypeValue = gardenInfoService.getGardenInfoById(gardenInfo.getGardenInfoId());
        garden.setGardenType(gardenTypeValue);

        seeds.getIds().removeIf(Objects::isNull);
        List<Seeds> seedsList = seedService.getAllSeeds(seeds.getIds());
        garden.setSeedType(seedsList);
        clientService.saveGardenToUser(userId, garden);
        return "redirect:/myGardens";
    }

    @GetMapping("/myGardens")
    public String showUsersGardens(Principal principal, Model model){
        String email = principal.getName();
        User user = userService.findByEmail(email);
        Long id = user.getId();
        Client client = clientService.getUserById(id);
        List<Garden> gardenList = client.getUserGardens();
        Set<Garden> gardenListNoDuplicate = new HashSet<Garden>();
        for(Garden garden : gardenList){
            gardenListNoDuplicate.add(garden);
        }
        List<Garden> updatedList = new ArrayList<>();
        for(Garden garden: gardenListNoDuplicate){
            updatedList.add(garden);
        }
       // List<Garden> gardenList  = gardenService.getAllGardens();
        model.addAttribute("gardenList", gardenListNoDuplicate);
        return "html/User/MyGardenList";
    }

    @GetMapping("/deleteGarden/{id}")
    public String deleteGarden(Principal principal, @PathVariable(value = "id") long id){
        String email = principal.getName();
        User user = userService.findByEmail(email);
        Long userId = user.getId();
        Client client = clientService.getUserById(userId);
        List<Garden> gardenList = client.getUserGardens();
        Set<Garden> removeDuplicates = new HashSet<Garden>();
        for(Garden garden : gardenList){
            removeDuplicates.add(garden);
        }
        List<Garden> updateGardenList = new ArrayList<Garden>();
        for(Garden garden: removeDuplicates){
            updateGardenList.add(garden);
        }
        System.out.println(updateGardenList);
        updateGardenList.remove(gardenService.getGardenbyId(id));
        client.setUserGardens(updateGardenList);
        gardenService.deleteGardenById(id);
        clientService.saveUser(client);
        System.out.println(client);
        System.out.println(updateGardenList);

        return "redirect:/myGardens";
    }

    @GetMapping("/updateGarden/{id}")
    public String showUpdateGardenForm(@PathVariable(value="id") long id, Model model){
        Garden garden = gardenService.getGardenbyId(id);
        System.out.println(garden);
        model.addAttribute("garden", garden);
        model.addAttribute("seeds", seedService.getAllSeeds());
        model.addAttribute("gardenInfo", gardenInfoService.getAllGardenInfo());
        model.addAttribute("house", houseService.getAllHouse());
        return "html/updateGar";
    }

    @PostMapping("/updateGarden")
    public String updateGarden(@ModelAttribute("garden") @Valid Garden garden,
                               @ModelAttribute("gardenInfo") GardenInfoSelectionDTO gardenInfo,
                               @ModelAttribute("seeds") SeedSelectionDTO seeds,
                               @ModelAttribute("house") HouseSelectionDTO house,
                               BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "html/CreateGarden";
        }

        House houseValue = houseService.getHouseById(house.getHouseId());
        garden.setHouseType(houseValue);


        GardenInfo gardenTypeValue = gardenInfoService.getGardenInfoById(gardenInfo.getGardenInfoId());
        garden.setGardenType(gardenTypeValue);

        seeds.getIds().removeIf(Objects::isNull);
        List<Seeds> seedsList = seedService.getAllSeeds(seeds.getIds());
        garden.setSeedType(seedsList);
        gardenService.saveGarden(garden);
        return "redirect:/myGardens";
    }

}
