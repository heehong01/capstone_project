package com.example.backend_capstone.jpa.service.GardenInfo;

import com.example.backend_capstone.jpa.enititymodels.GardenInfo;

import java.util.List;

public interface GardenInfoService {
    List<GardenInfo> getAllGardenInfo();
    GardenInfo getGardenInfoById(long gardenInfoId);
    void deleteGardenInfoById(Long id);
    void saveGardenInfo(GardenInfo gardenInfo);
}
