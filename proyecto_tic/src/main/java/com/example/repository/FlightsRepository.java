package com.example.repository;

import com.example.entities.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface FlightsRepository extends JpaRepository<Flights, Long> {

    List<Flights> findByOriginAndDestinationAndState(String origen, String destino, int i);

    List<Flights> findByIdAirline(Long idAerolinea);
    
}
