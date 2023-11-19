package com.example.repository;

import com.example.entities.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsRepository extends JpaRepository<Tickets, Long> {

    List<Tickets> findByIdFlight(Long idFlights);

    List<Tickets> findByPasaport(String passport);
}
