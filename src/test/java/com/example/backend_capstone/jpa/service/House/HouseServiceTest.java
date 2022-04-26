package com.example.backend_capstone.jpa.service.House;

import com.example.backend_capstone.jpa.enititymodels.House;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.security.core.userdetails.memory.UserAttributeEditor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HouseServiceTest {
    @Autowired
    private HouseService houseService;

    @Test
    void getAllHouse() {
        List<House> allHouse = houseService.getAllHouse();
        int beforeAddingMoreHouse = allHouse.size();

        House house1 = new House();
        house1.setHouseId(7L);
        house1.setHouseName("RV");
        house1.setHouseDescription("House on wheels");
        houseService.saveHouse(house1);
        int afterAddingMoreHouse = houseService.getAllHouse().size();
        Assertions.assertThat(afterAddingMoreHouse).isEqualTo(beforeAddingMoreHouse + 1);
        Assertions.assertThat(allHouse.contains(house1)).isTrue();

    }

    @Test
    void saveHouse(){

    }

    @Test
    void getHouseById() {
    }

    @Test
    void deleteHouseById() {
    }
}