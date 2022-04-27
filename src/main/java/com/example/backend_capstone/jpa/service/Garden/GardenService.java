package com.example.backend_capstone.jpa.service.Garden;

import com.example.backend_capstone.jpa.enititymodels.Garden;

import java.util.List;
import java.util.Set;

public interface GardenService {
    List<Garden> getAllGardens();
    void saveGarden(Garden garden);
    Garden getGardenbyId(long gardenId);
    void deleteGardenById(long gardenId);
    List<Garden> getDistinctByGardenId(Long id);
}
