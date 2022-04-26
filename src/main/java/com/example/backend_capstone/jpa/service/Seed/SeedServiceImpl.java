package com.example.backend_capstone.jpa.service.Seed;

import com.example.backend_capstone.jpa.enititymodels.Seeds;
import com.example.backend_capstone.jpa.repository.SeedRepository;
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

    @Override
    public Seeds getSeedById(Long id){
        return seedRepository.getById(id);
    }

    @Override
    public void deleteSeedById(long id){
        this.seedRepository.deleteById(id);
    }

    @Override
    public void saveSeed(Seeds seed) {
        this.seedRepository.save(seed);
    }
}
