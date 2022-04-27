package com.example.backend_capstone.jpa.service.Client;

import com.example.backend_capstone.jpa.enititymodels.Client;
import com.example.backend_capstone.jpa.enititymodels.Garden;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Set;

public interface ClientService extends UserDetailsService {
    //CONSIDER CHANGING TO ID BEING USERNAME
    List<Client> getAllUsers();
    void saveUser(Client client);
    Client getUserById(long userId);
    void deleteUserById(long userId);
    void saveGardenToUser(long user_id, Garden garden);
    List<Garden> getGardenByUser(long userId);
    List<Garden> deleteGardenByUser(long userId);
}
