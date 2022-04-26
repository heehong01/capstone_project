package com.example.backend_capstone.jpa.controller.Admin;

import com.example.backend_capstone.jpa.enititymodels.Seeds;
import com.example.backend_capstone.jpa.service.Seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminSeedController {
    private SeedService seedService;

    @Autowired
    public AdminSeedController(SeedService seedService){
        this.seedService = seedService;
    }

    @GetMapping("/admin/seedList")
    public String showSeedList(Model model){
        model.addAttribute("listSeed", seedService.getAllSeeds());
        return "html/admin/SeedList";
    }

    @GetMapping("/admin/updateSeed/{id}")
    public String showFormForSeedUpdate(@PathVariable(value = "id") long id, Model model){
        Seeds seed = seedService.getSeedById(id);

        model.addAttribute("seed", seed);
        return "html/admin/UpdateSeed";
    }
    @GetMapping("/admin/deleteSeed/{id}")
    public String deleteUser(@PathVariable(value="id") long id){
        this.seedService.deleteSeedById(id);
        return  "redirect:/admin/seedList";
    }
}
