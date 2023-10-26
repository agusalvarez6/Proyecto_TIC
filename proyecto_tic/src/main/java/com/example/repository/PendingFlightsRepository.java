package com.example.repository;

import com.example.entities.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendingFlightsRepository extends JpaRepository<PendingFlights, Long> {

    List<Flights> findByOriginOrDestination(Long idAeropuerto, Long idAeropuerto2);

    PendingFlights findPendingFlightByid(Long idFlights);
}
