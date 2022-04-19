package com.example.backend_capstone.jpa.service;

import com.example.backend_capstone.jpa.enititymodels.GardenInfo;

import java.util.List;

public interface GardenInfoService {
    List<GardenInfo> getAllGardenInfo();
    GardenInfo getGardenInfoById(long gardenInfoId);

}
