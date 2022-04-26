package com.example.backend_capstone.jpa.controller.Admin;

import com.example.backend_capstone.jpa.service.Client.ClientService;
import com.example.backend_capstone.jpa.security.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private ClientService clientService;
    private UserService userService;

    @Autowired
    public AdminController(ClientService clientService){
        this.clientService = clientService;
    }



    @GetMapping("/admin/UserList")
    public String getAllUsers(Model model) {
        model.addAttribute("listUser", userService.getAllUser());
        return "html/admin/UserList";
    }

}
