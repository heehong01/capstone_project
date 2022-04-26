package com.example.backend_capstone.jpa.controller.Admin;

import com.example.backend_capstone.jpa.enititymodels.House;
import com.example.backend_capstone.jpa.service.House.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminHouseController {
    private HouseService houseService;

    @Autowired
    public AdminHouseController(HouseService houseService){
        this.houseService = houseService;
    }

    @GetMapping("/admin/houseList")
    public String showHouseList(Model model){
        model.addAttribute("listHouse", houseService.getAllHouse());
        return "html/admin/HouseList";
    }

    @GetMapping("/admin/updateHouse/{id}")
    public String showFormForHouseUpdate(@PathVariable(value = "id") long id, Model model){
        House house = houseService.getHouseById(id);
        model.addAttribute("house", house);
        return "html/admin/UpdateHouse";
    }
    @GetMapping("/admin/deleteHouse/{id}")
    public String deleteUser(@PathVariable(value="id") long id){
        this.houseService.deleteHouseById(id);
        return "redirect:/admin/houseList";
    }

}
