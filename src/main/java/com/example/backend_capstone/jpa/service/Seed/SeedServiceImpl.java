package com.example.backend_capstone.jpa.service.Seed;

import com.example.backend_capstone.jpa.enititymodels.Seeds;
import com.example.backend_capstone.jpa.repository.SeedRepository;
import com.example.backend_capstone.jpa.service.Seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeedServiceImpl implements SeedService {
    private SeedRepository seedRepository;

    @Autowired
    public SeedServiceImpl(SeedRepository seedRepository){
        this.seedRepository = seedRepository;
    }

    @Override
    public List<Seeds> getAllSeeds() {
        return seedRepository.findAll();
    }

    @Override
    public List<Seeds> getAllSeeds(List<Long> ids) {
        return seedRepository.findAllById(ids);

    }
}
