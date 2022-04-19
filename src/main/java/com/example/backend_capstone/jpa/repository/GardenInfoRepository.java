package com.example.backend_capstone.jpa.repository;

import com.example.backend_capstone.jpa.enititymodels.GardenInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardenInfoRepository extends JpaRepository<GardenInfo, Long> {
}
