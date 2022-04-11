package com.example.backend_capstone.jpa.repository;

import com.example.backend_capstone.jpa.enititymodels.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
