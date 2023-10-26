package com.example.repository;

import com.example.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandingStripRepository extends JpaRepository<LandingStrip, Long> {
}
