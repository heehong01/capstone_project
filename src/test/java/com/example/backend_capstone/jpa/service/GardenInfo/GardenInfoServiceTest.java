package com.example.backend_capstone.jpa.service.GardenInfo;

import com.example.backend_capstone.jpa.enititymodels.GardenInfo;
import com.example.backend_capstone.jpa.service.GardenInfo.GardenInfoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GardenInfoServiceTest {
    @Autowired
    GardenInfoService gardenInfoService;

    @Test
    void getAllGardenInfo() {
        List<GardenInfo> allGardenInfo = gardenInfoService.getAllGardenInfo();
        int beforeAddingMoreGardenInfo = allGardenInfo.size();

        GardenInfo gardenInfo = new GardenInfo();
        gardenInfo.setGardenName("Farming");
        gardenInfo.setGardenDescription("A place with more than one acre of land to sow on");
        gardenInfo.setGardenNameId(7L);

        gardenInfoService.saveGardenInfo(gardenInfo);

        List<GardenInfo> updatedAllGardenInfo = gardenInfoService.getAllGardenInfo();
        int afterAddingMoreGardenInfo = updatedAllGardenInfo.size();

        Assertions.assertThat(afterAddingMoreGardenInfo).isEqualTo(beforeAddingMoreGardenInfo + 1);
        Assertions.assertThat(updatedAllGardenInfo.contains(gardenInfo));

    }

    @Test
    void getGardenInfoById() {
        List<GardenInfo> allGardenInfo = gardenInfoService.getAllGardenInfo();
        GardenInfo gardenInfo = allGardenInfo.get(0);
        if(gardenInfo != null){
            GardenInfo gardenInfo1 = gardenInfoService.getGardenInfoById(gardenInfo.getGardenNameId());
            Assertions.assertThat(gardenInfo.getGardenNameId()).isEqualTo(gardenInfo1.getGardenNameId());
            Assertions.assertThat(gardenInfo.getGardenName()).isEqualTo(gardenInfo1.getGardenName());
            Assertions.assertThat(gardenInfo.getGardenDescription()).isEqualTo(gardenInfo1.getGardenDescription());
        }
    }

    @Test
    void deleteGardenInfoById() {
        List<GardenInfo> allGardenInfo = gardenInfoService.getAllGardenInfo();
        int beforeDeletingMoreGardenInfo = allGardenInfo.size();
        GardenInfo gardenInfo = allGardenInfo.get(0);
        if(gardenInfo != null){
            gardenInfoService.deleteGardenInfoById(gardenInfo.getGardenNameId());
            List<GardenInfo> updatedAllGardenInfo = gardenInfoService.getAllGardenInfo();
            int afterDeletingGardenInfo = updatedAllGardenInfo.size();
            Assertions.assertThat(afterDeletingGardenInfo).isEqualTo(beforeDeletingMoreGardenInfo - 1);
            Assertions.assertThat(updatedAllGardenInfo.contains(gardenInfo)).isFalse();
        }

    }

    @Test
    void saveGardenInfo() {
        List<GardenInfo> allGardenInfo = gardenInfoService.getAllGardenInfo();
        int beforeAddingMoreGardenInfo = allGardenInfo.size();

        GardenInfo gardenInfo = new GardenInfo();
        gardenInfo.setGardenName("Farming");
        gardenInfo.setGardenDescription("A place with more than one acre of land to sow on");
        gardenInfo.setGardenNameId(7L);

        gardenInfoService.saveGardenInfo(gardenInfo);

        List<GardenInfo> updatedAllGardenInfo = gardenInfoService.getAllGardenInfo();
        int afterAddingMoreGardenInfo = updatedAllGardenInfo.size();

        Assertions.assertThat(afterAddingMoreGardenInfo).isEqualTo(beforeAddingMoreGardenInfo + 1);
        Assertions.assertThat(updatedAllGardenInfo.contains(gardenInfo));

    }
}