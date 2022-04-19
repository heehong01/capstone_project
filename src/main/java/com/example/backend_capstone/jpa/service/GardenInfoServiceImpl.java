package com.example.backend_capstone.jpa.service;

import com.example.backend_capstone.jpa.enititymodels.GardenInfo;
import com.example.backend_capstone.jpa.repository.GardenInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GardenInfoServiceImpl implements GardenInfoService{
    private GardenInfoRepository gardenInfoRepository;

    @Autowired
    public GardenInfoServiceImpl(GardenInfoRepository gardenInfoRepository){
        this.gardenInfoRepository = gardenInfoRepository;
    }

    @Override
    public List<GardenInfo> getAllGardenInfo() {
        return gardenInfoRepository.findAll();
    }

    @Override
    public GardenInfo getGardenInfoById(long gardenInfoId) {
        GardenInfo garden = gardenInfoRepository.getById(gardenInfoId);
        if(garden == null){
            throw new GardenInfoNotFoundException();
        }
        return garden;
    }
}
