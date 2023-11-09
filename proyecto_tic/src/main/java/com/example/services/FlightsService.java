package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Account;
import com.example.entities.Flights;
import com.example.entities.PendingFlights;
import com.example.entities.Plane;
import com.example.repository.AirportRepository;
import com.example.repository.FlightsRepository;
import com.example.repository.PendingFlightsRepository;
import com.example.repository.PlaneRepository;


@Service
public class FlightsService {
     
    @Autowired
    private FlightsRepository flightsRepository;

    @Autowired
    private AirportRepository airportRepository;


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

    public List<Flights> verVuelosAprobadoso(String origen, String destino) {
        return flightsRepository.findByOriginAndDestinationAndState(origen, destino, 1);
    }
 
    public List<PendingFlights> verVuelosDeAeropuerto(String idAeropuerto) {
        return pendingFlightsRepository.findByOriginOrDestination(idAeropuerto, idAeropuerto);
    }
    
    public List<Flights> verVuelosDeAerolinea(Long idAerolinea) {
        return flightsRepository.findByIdAirline(idAerolinea);
    }
     
    public void confirmarVuelo(Flights flights,String locate) {
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
    
   public boolean VerificarDestino(String IATA){
        return (airportRepository.findByIATA(IATA) != null);
    }

    public Plane ComprobarAvion(String Numero,Long idAereolinea){
        return planeRepository.findByNumeroAndIdAirline(Numero, idAereolinea);
    }

}
