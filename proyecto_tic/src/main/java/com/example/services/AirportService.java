package com.example.services;

import com.example.entities.*;
import com.example.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService {
    @Autowired
    AirportRepository airportRepository;

    @Autowired
    private PendingFlightsRepository pendingFlightsRepository;

    public Airport saveAirport(Airport airport) {
        if (airportRepository.findByiATA(airport.getIATA()) == null) {
            return airportRepository.save(airport);
        }
        return null;
    }

    public boolean VerificarDestino(String IATA){
        return (airportRepository.findByiATA(IATA) != null);
    }

     public List<PendingFlights> verVuelosDeAeropuerto(String idAeropuerto) {
        return pendingFlightsRepository.findByOriginOrDestination(idAeropuerto, idAeropuerto);
    }

    public Airport getAirport(Long idAccount){
        Airport aeropuerto = airportRepository.findByIdAccount(idAccount);
        if(aeropuerto!=null){
            return aeropuerto;
        }else{
            return null;
        }
    }
}
