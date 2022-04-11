package com.example.backend_capstone.jpa.controller;

import com.example.backend_capstone.jpa.enititymodels.User;
import com.example.backend_capstone.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

//SHOW NEW EMPLOYEE FORM
    @GetMapping("/registerForm")
    public String showRegistrationForm(Model model) {
        // create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "html/RegistrationPage";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        // create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "html/LoginPage";
    }
//SAVE EMPLOYEE
    @PostMapping("/registerUser")
    public String saveEmployee(@ModelAttribute("user") @Valid User user,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "html/RegistrationPage";
        }

        // save employee to database
        userService.saveUser(user);
        return "redirect:/UserList";
    }

    @GetMapping("/UserList")
    public String getAllEmployees(Model model) {
        model.addAttribute("listUser", userService.getAllUsers());
        return "html/UserList";
    }

}
