package com.example.backend_capstone.jpa.service;

import com.example.backend_capstone.jpa.enititymodels.Garden;
import com.example.backend_capstone.jpa.enititymodels.User;

import java.util.List;

public interface UserService {
    //CONSIDER CHANGING TO ID BEING USERNAME
    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(long userId);
    void deleteUserById(long userId);
    void saveGardenToUser(long user_id, Garden garden);
    List<Garden> getGardenByUser(long userId);
}
