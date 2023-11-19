package com.example.repository;

import com.example.entities.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface FlightsRepository extends JpaRepository<Flights, Long> {

    List<Flights> findByIdAirline(Long idAerolinea);

    Flights findByCode(String code);

    List<Flights> findByOriginAndDestinationAndStateOriginAndStateDestination(String origen, String destino, int i, int t);

    List<Flights> findByOriginAndStateOrigin(String location, int i);

    List<Flights> findByDestinationAndStateDestination(String location, int i);
    
}
