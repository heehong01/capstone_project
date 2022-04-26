package com.example.backend_capstone.jpa.service.Seed;

import com.example.backend_capstone.jpa.enititymodels.Seeds;

import java.util.List;

public interface SeedService {
    List<Seeds> getAllSeeds();
    List<Seeds> getAllSeeds(List<Long> ids);
    Seeds getSeedById(Long id);
    void deleteSeedById(long id);
    void saveSeed(Seeds seed);
}
