package com.example.backend_capstone.jpa.service.Seed;

import com.example.backend_capstone.jpa.enititymodels.Seeds;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.assertj.core.api.Assertions;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SeedServiceTest {
    @BeforeEach
    void setup(){

    }

    @Autowired
    private SeedService seedService;

    @Test
    void getAllSeeds() {
        List<Seeds> allSeeds = seedService.getAllSeeds();
        int beforeAddingMoreSeeds = allSeeds.size();

        Seeds seed1 = new Seeds();
        seed1.setSeedId(7L);
        seed1.setSeedName("Tomato");
        seed1.setSeedDescription("THIS IS A TOMATO");
        seedService.saveSeed(seed1);
        int afterAddingMoreSeeds = seedService.getAllSeeds().size();
        Assertions.assertThat(afterAddingMoreSeeds).isEqualTo(beforeAddingMoreSeeds + 1);
        Assertions.assertThat(allSeeds.contains(seed1)).isTrue();
    }


    @Test
    void getSeedById() {
        List<Seeds> allSeeds = seedService.getAllSeeds();
        Seeds seed1 = allSeeds.get(0);
        if(seed1 != null){
            Seeds seed2 = seedService.getSeedById(seed1.getSeedId());
            Assertions.assertThat(seed1.getSeedId()).isEqualTo(seed2.getSeedId());
            Assertions.assertThat(seed1.getSeedName()).isEqualTo(seed2.getSeedName());
            Assertions.assertThat(seed1.getSeedDescription()).isEqualTo(seed2.getSeedDescription());
        }
    }

    @Test
    void deleteSeedById() {
        List<Seeds> allSeeds = seedService.getAllSeeds();
        Seeds seedRemoved = allSeeds.get(0);
        int beforeSeedRemoved = allSeeds.size();
        if(seedRemoved != null){
            seedService.deleteSeedById(seedRemoved.getSeedId());
            List<Seeds> allSeed = seedService.getAllSeeds();
            int afterSeedRemoved = allSeed.size();
            Assertions.assertThat(afterSeedRemoved).isEqualTo(beforeSeedRemoved - 1);
            Assertions.assertThat(allSeed.contains(seedRemoved)).isFalse();
        }
    }

    @Test
    void saveHouse(){
        List<Seeds> allSeeds = seedService.getAllSeeds();
        int beforeSeedAdded = allSeeds.size();

        Seeds seedAdd = new Seeds();
        seedAdd.setSeedName("Daikon");
        seedAdd.setSeedDescription("Asian Radish");

        seedService.saveSeed(seedAdd);

        List<Seeds> allSeedsUpdated = seedService.getAllSeeds();
        int afterSeedAdded = allSeedsUpdated.size();

        Assertions.assertThat(afterSeedAdded).isEqualTo(beforeSeedAdded + 1);
        Assertions.assertThat(allSeeds.contains(seedAdd)).isTrue();
    }
}