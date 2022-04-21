package com.example.backend_capstone.jpa.service.Garden;

import com.example.backend_capstone.jpa.enititymodels.Garden;

import java.util.List;

public interface GardenService {
    List<Garden> getAllGardens();
    void saveGarden(Garden garden);
    Garden getGardenbyId(long gardenId);
    void deleteGardenById(long gardenId);
}
