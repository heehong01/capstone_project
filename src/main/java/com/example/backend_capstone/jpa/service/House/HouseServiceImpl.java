package com.example.backend_capstone.jpa.service.House;

import com.example.backend_capstone.jpa.Exception.HouseNotFoundException;
import com.example.backend_capstone.jpa.enititymodels.House;
import com.example.backend_capstone.jpa.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    private HouseRepository houseRepository;

    @Autowired
    public HouseServiceImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Override
    public List<House> getAllHouse() {
        return houseRepository.findAll();
    }

    @Override
    public House getHouseById(long houseId) {
        House house = houseRepository.getById(houseId);
        if(house == null){
            throw new HouseNotFoundException();
        }
        return house;
    }

    @Override
    public void deleteHouseById(long id) {
        this.houseRepository.deleteById(id);
    }

    @Override
    public void saveHouse(House house) {
        this.houseRepository.save(house);
    }
}
