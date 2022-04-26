package com.example.backend_capstone.jpa.service.House;


import com.example.backend_capstone.jpa.enititymodels.House;

import java.util.List;

public interface HouseService {
    List<House> getAllHouse();
    House getHouseById(long houseId);
    void deleteHouseById(long id);
    void saveHouse(House house);
}
