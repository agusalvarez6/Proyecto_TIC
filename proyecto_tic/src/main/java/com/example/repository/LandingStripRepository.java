package com.example.repository;

import com.example.entities.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandingStripRepository extends JpaRepository<LandingStrip, Long> {

    List<LandingStrip> findByIdAirport(String iATA);
}
