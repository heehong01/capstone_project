package com.example.backend_capstone.jpa.repository;

import com.example.backend_capstone.jpa.enititymodels.Garden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardenRepository extends JpaRepository<Garden, Long> {
}
