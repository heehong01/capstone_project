package com.example.backend_capstone.jpa.repository;

import com.example.backend_capstone.jpa.enititymodels.Garden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface GardenRepository extends JpaRepository<Garden, Long> {
    List<Garden> getDistinctByGardenId(Long id);
}
