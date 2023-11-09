package com.example.services;

import com.example.entities.*;
import com.example.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FlightsService {
     
    @Autowired
    FlightsRepository flightsRepository;

    @Autowired
    private PendingFlightsRepository pendingFlightsRepository;

    @Autowired
    private PlaneRepository planeRepository;


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

    public List<Flights> verVuelosAprobadoso(Long origen, Long destino) {
        return flightsRepository.findByOriginAndDestinationAndState(origen, destino, 1);
    }
 
    public List<PendingFlights> verVuelosDeAeropuerto(Long idAeropuerto) {
        return pendingFlightsRepository.findByOriginOrDestination(idAeropuerto, idAeropuerto);
    }
    
    public List<Flights> verVuelosDeAerolinea(Long idAerolinea) {
        return flightsRepository.findByIdAirline(idAerolinea);
    }
     
    public void confirmarVuelo(Flights flights,Long locate) {
        PendingFlights pendingFlights = pendingFlightsRepository.findByIdPendingFlights(flights.getIdFlights());
        if(flights.getDestination()==locate){
            pendingFlights.setStateDestination(1);

        }else if(flights.getOrigin()==locate){
            pendingFlights.setStateOrigin(1);
        }
        if(pendingFlights.getStateDestination()==1 && pendingFlights.getStateOrigin()==1){
            flights.setState(1);
        }
    }

    public void RechazarVuelo(Flights flights){
        PendingFlights pendingFlights = pendingFlightsRepository.findByIdPendingFlights(flights.getIdFlights());
        pendingFlightsRepository.delete(pendingFlights);
        flightsRepository.delete(flights);
    }

    public Plane savePlane(Plane plane){
        return planeRepository.save(plane);
    }

    public List<Plane> verTodosLosAviones(Long idAerolinea){
        return planeRepository.findByIdAirline(idAerolinea);
    }
     public Airport VerificarDestino(String IATA){
        return airportRepository.findByIATA(IATA);
    }

}
