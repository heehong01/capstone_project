package com.example.backend_capstone.jpa.controller;

import com.example.backend_capstone.jpa.enititymodels.Client;
import com.example.backend_capstone.jpa.service.Client.ClientService;
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
public class ClientController {


    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }




    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get user from the service
        Client client = clientService.getUserById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("user", client);
        return "html/UpdateUser";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.clientService.deleteUserById(id);
        return "redirect:/UserList";
    }

}
