package com.example.services;

import com.example.entities.*;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService {
    @Autowired
    AirportRepository airportRepository;

    public Airport saveAirport(Airport airport) {
        if (airportRepository.findByiATA(airport.getIATA()) == null) {
            return airportRepository.save(airport);
        }
        return null;
    }
}
