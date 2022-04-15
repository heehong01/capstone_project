package com.example.backend_capstone.jpa.service;

import com.example.backend_capstone.jpa.enititymodels.Seeds;

import java.util.List;

public interface SeedService {
    List<Seeds> getAllSeeds();
    List<Seeds> getAllSeeds(List<Long> ids);
}
