package com.example.backend_capstone.jpa.user;

import com.example.backend_capstone.jpa.DTO.UserRegistrationDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);
    User save(UserRegistrationDTO registration);
}


