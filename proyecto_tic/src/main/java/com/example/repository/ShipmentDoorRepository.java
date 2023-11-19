package com.example.repository;

import com.example.entities.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface ShipmentDoorRepository extends JpaRepository<ShipmentDoor, Long> {

    List<ShipmentDoor> findByIdAirport(String iATA);

    ShipmentDoor findByIdDoor(Long id);
}
