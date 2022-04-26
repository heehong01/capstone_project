package com.example.backend_capstone.jpa.security.user;

import com.example.backend_capstone.jpa.DTO.UserRegistrationDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
    User findByEmail(String email);
    User save(UserRegistrationDTO registration);
    List<User> getAllUser();
}


