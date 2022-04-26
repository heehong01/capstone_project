package com.example.backend_capstone.jpa.security.user;

import com.example.backend_capstone.jpa.DTO.UserRegistrationDTO;
import com.example.backend_capstone.jpa.enititymodels.Client;
import com.example.backend_capstone.jpa.service.Client.ClientService;
import com.example.backend_capstone.jpa.security.user.User;
import com.example.backend_capstone.jpa.security.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;
    private ClientService clientService;

    public UserRegistrationController(UserService userService, ClientService clientService) {
        this.userService = userService;
        this.clientService = clientService;
    }

    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrationDto() {
        return new UserRegistrationDTO();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "html/RegistrationPage";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDTO userDto, BindingResult result){

        User existing = userService.findByUsername(userDto.getUsername());
        if (existing != null){
            result.rejectValue("username", null, "There is already an account registered with that username");
        }

        User existingEmail = userService.findByEmail(userDto.getEmail());
        if(existingEmail != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()){
            return "html/RegistrationPage";
        }
        User user = userService.save(userDto);
        Client client = createClientFromUserDto(userDto, user.getId());
        clientService.saveUser(client);

        return "redirect:/login";
    }

    private Client createClientFromUserDto(UserRegistrationDTO userDTO, Long id){
        Client client = new Client();

        client.setEmail(userDTO.getEmail());
        client.setFirstName(userDTO.getFirstName());
        client.setLastName(userDTO.getLastName());
        client.setPassword(userDTO.getPassword());
        client.setUsername(userDTO.getUsername());

        return client;
    }
}

