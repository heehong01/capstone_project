package com.example.backend_capstone.jpa.service.House;

import com.example.backend_capstone.jpa.enititymodels.House;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.memory.UserAttributeEditor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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
        Assertions.assertThat(houseService.getAllHouse().contains(house1));

    }

    @Test
    void saveHouse(){
        List<House> allHouses = houseService.getAllHouse();
        int beforeHouseAdded = allHouses.size();

        House houseAdd = new House();
        houseAdd.setHouseId(8L);
        houseAdd.setHouseName("Yacht");
        houseAdd.setHouseDescription("House on ocean");
        houseService.saveHouse(houseAdd);
        int afterAddingHouse = houseService.getAllHouse().size();

        Assertions.assertThat(afterAddingHouse).isEqualTo(beforeHouseAdded + 1);
        Assertions.assertThat(houseService.getAllHouse().contains(houseAdd));

    }

    @Test
    void getHouseById() {
        List<House> allHouses = houseService.getAllHouse();
        House house1 = allHouses.get(0);
        if(house1 != null){
            House house2 = houseService.getHouseById(house1.getHouseId());
            Assertions.assertThat(house1.getHouseId()).isEqualTo(house2.getHouseId());
            Assertions.assertThat(house1.getHouseName()).isEqualTo(house2.getHouseName());
            Assertions.assertThat(house1.getHouseDescription()).isEqualTo(house2.getHouseDescription());
        }
    }

    @Test
    void deleteHouseById() {
        List<House> allHouses = houseService.getAllHouse();
        int beforeDeletingHouse = allHouses.size();
        House house1 = allHouses.get(0);
        if(house1 != null){
            houseService.deleteHouseById(house1.getHouseId());
            List<House> updatedAllHouse = houseService.getAllHouse();
            int afterDeletingHouse = updatedAllHouse.size();
            Assertions.assertThat(afterDeletingHouse).isEqualTo(beforeDeletingHouse -1);
            Assertions.assertThat(updatedAllHouse.contains(house1)).isFalse();

        }
    }
}