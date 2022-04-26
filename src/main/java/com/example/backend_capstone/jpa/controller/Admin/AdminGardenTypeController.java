package com.example.backend_capstone.jpa.controller.Admin;

import com.example.backend_capstone.jpa.enititymodels.GardenInfo;
import com.example.backend_capstone.jpa.enititymodels.Seeds;
import com.example.backend_capstone.jpa.service.GardenInfo.GardenInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminGardenTypeController {
    private GardenInfoService gardenInfoService;

    @Autowired
    public AdminGardenTypeController(GardenInfoService gardenInfoService){
        this.gardenInfoService = gardenInfoService;
    }

    @GetMapping("/admin/gardenTypeList")
    public String showSeedList(Model model){
        model.addAttribute("listSeed", gardenInfoService.getAllGardenInfo());
        return "html/admin/GardenTypeList";
    }

    @GetMapping("/admin/updateGardenType/{id}")
    public String showFormForSeedUpdate(@PathVariable(value = "id") long id, Model model){
        GardenInfo gardenInfo = gardenInfoService.getGardenInfoById(id);
        model.addAttribute("gardenInfo", gardenInfo);
        return "html/admin/UpdateGardenType";
    }
    @GetMapping("/admin/deleteGardenType/{id}")
    public String deleteUser(@PathVariable(value="id") long id){
        this.gardenInfoService.deleteGardenInfoById(id);
        return  "redirect:/admin/gardenTypeList";
    }
}
