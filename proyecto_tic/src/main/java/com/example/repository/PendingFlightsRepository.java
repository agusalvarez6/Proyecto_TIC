package com.example.repository;

import com.example.entities.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendingFlightsRepository extends JpaRepository<PendingFlights, Long> {
 
    List<PendingFlights> findByOriginOrDestination(String idAeropuerto, String idAeropuerto2);

    PendingFlights findByIdPendingFlights(Long idFlights);
}
