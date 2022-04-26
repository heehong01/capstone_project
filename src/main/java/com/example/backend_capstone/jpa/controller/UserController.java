package com.example.backend_capstone.jpa.controller;

import com.example.backend_capstone.jpa.enititymodels.Client;
import com.example.backend_capstone.jpa.enititymodels.Garden;
import com.example.backend_capstone.jpa.enititymodels.Seeds;
import com.example.backend_capstone.jpa.security.user.User;
import com.example.backend_capstone.jpa.security.user.UserService;
import com.example.backend_capstone.jpa.service.Client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    private ClientService clientService;

    public UserController(UserService userService, ClientService clientService) {
        this.userService = userService;
        this.clientService = clientService;
    }

    @GetMapping("/myPage")
    public String myPage(Principal principal, Model model){
        String email = principal.getName();
        User user = userService.findByEmail(email);
        Long id = user.getId();
        Client client = clientService.getUserById(id);
        System.out.println(client);
        model.addAttribute("user", client);
        return "/html/User/MyPage";
    }

    @GetMapping("/myGardens")
    public String showUsersGardens(Principal principal, Model model){
        String email = principal.getName();
        User user = userService.findByEmail(email);
        Long id = user.getId();
        Client client = clientService.getUserById(id);
        List<Garden> gardenList = client.getUserGardens();
        model.addAttribute("gardenList", gardenList);
        List<String> stringValOfSeedList = new ArrayList<>();
        for(Garden garden: gardenList){
            String value = "";
            List<Seeds> seedsList =  garden.getSeedType();
            for(Seeds seed: seedsList){
                value += (seed.getSeedName() + "\n");
            }
            stringValOfSeedList.add(value);
            value = "";
        }
        model.addAttribute("seedList", stringValOfSeedList);

        return "html/User/MyGardenList";
    }
}
