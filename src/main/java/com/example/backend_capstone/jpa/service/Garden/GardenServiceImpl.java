package com.example.backend_capstone.jpa.service.Garden;

import com.example.backend_capstone.jpa.enititymodels.Garden;
import com.example.backend_capstone.jpa.repository.GardenRepository;
import com.example.backend_capstone.jpa.Exception.GardenNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GardenServiceImpl implements GardenService {
    private GardenRepository gardenRepository;

    @Autowired
    public GardenServiceImpl(GardenRepository gardenRepository){
        this.gardenRepository = gardenRepository;
    }

    @Override
    public List<Garden> getAllGardens(){
        return gardenRepository.findAll();
    }

    @Override
    public void saveGarden(Garden garden) {
        this.gardenRepository.save(garden);
    }

    @Override
    public Garden getGardenbyId(long gardenId) {
        Garden garden = gardenRepository.getById(gardenId);
        if(garden == null){
            throw new GardenNotFoundException();
        }
        return garden;
    }

    @Override
    public void deleteGardenById(long gardenId) {
        this.gardenRepository.deleteById(gardenId);
    }

}
