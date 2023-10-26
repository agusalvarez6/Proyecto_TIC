package com.example.services;

import com.example.entities.*;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightsService {
    @Autowired
    FlightsRepository flightsRepository;

    @Autowired
    private PendingFlightsRepository pendingFlightsRepository;

    public Flights saveFlights(Flights flights) {
        PendingFlights pendingFlights = new PendingFlights();
        pendingFlights.setIdFlights(flights.getIdFlights());
        pendingFlights.setOrigin(flights.getOrigin());
        pendingFlights.setDestination(flights.getDestination());
        pendingFlights.setStateOrigin(0);
        pendingFlights.setStateDestination(0);
        pendingFlightsRepository.save(pendingFlights);
        return flightsRepository.save(flights);
    }

    public List<Flights> verTodosLosVuelos() {
        return flightsRepository.findAll();
    }

    public List<Flights> verVuelosAprobadoso(String origen, String destino) {
        return flightsRepository.findByOriginAndDestinationAndState(origen, destino, 1);
    }

    public List<Flights> verVuelosDeAeropuerto(Long idAeropuerto) {
        return pendingFlightsRepository.findByOriginOrDestination(idAeropuerto, idAeropuerto);
    }
    public List<Flights> verVuelosDeAerolinea(Long idAerolinea) {
        return flightsRepository.findByIdAirline(idAerolinea);
    }
    public Flights confirmarVuelo(Flights flights,String locate) {
        PendingFlights pendingFlights = pendingFlightsRepository.findPendingFlightByid(flights.getIdFlights());
        if(flights.getDestination()==locate){
            pendingFlights.setStateDestination(1);
        }else if(flights.getOrigin()==locate){
            pendingFlights.setStateOrigin(1);
        }
        if(pendingFlights.getStateDestination()==1 and pendingFlights.getStateOrigin()==1){
            flights.setState(1);
        }
    }

    public Flights RechazarVuelo(Flights flights){
        PendingFlights pendingFlights = pendingFlightsRepository.findPendingFlightByid(flights.getIdFlights());
        pendingFlightsRepository.delete(pendingFlights);
        flightsRepository.delete(flights);
    }

}