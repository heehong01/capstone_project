package com.example.backend_capstone.jpa.service;

import com.example.backend_capstone.jpa.enititymodels.Client;
import com.example.backend_capstone.jpa.enititymodels.Garden;
import com.example.backend_capstone.jpa.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAllUsers() {
        return clientRepository.findAll();
    }

    @Override
    public void saveUser(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getUserById(long userId) {
        Client client = clientRepository.getById(userId);
        if(client == null ){
            throw new ClientNotFoundException();
        }
        return client;
    }

    @Override
    public void deleteUserById(long userId) {
        clientRepository.deleteById(userId);
    }


    @Override
    public void saveGardenToUser(long user_id, Garden garden) {
        Client client = getUserById(user_id);
        List<Garden> userGardens = getGardenByUser(user_id);
        boolean isInGardenList = false;
        for(Garden gardenCheck : userGardens){
            if(gardenCheck.getGardenId() == garden.getGardenId()){
                isInGardenList = true;
                break;
            }
        }
        if(!isInGardenList){
            userGardens.add(garden);
            client.setUserGardens(userGardens);
            saveUser(client);
        }
    }

    @Override
    public List<Garden> getGardenByUser(long userId) {
        Client client = getUserById(userId);
        return client.getUserGardens();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
