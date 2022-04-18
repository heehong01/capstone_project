package com.example.backend_capstone.jpa.service;

import com.example.backend_capstone.jpa.enititymodels.Garden;
import com.example.backend_capstone.jpa.enititymodels.User;
import com.example.backend_capstone.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(long userId) {
        User user = userRepository.getById(userId);
        if(user == null ){
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override
    public void deleteUserById(long userId) {
        userRepository.deleteById(userId);
    }


    @Override
    public void saveGardenToUser(long user_id, Garden garden) {
        User user = getUserById(user_id);
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
            user.setUserGardens(userGardens);
            saveUser(user);
        }
    }

    @Override
    public List<Garden> getGardenByUser(long userId) {
        User user = getUserById(userId);
        return user.getUserGardens();
    }
    
}
