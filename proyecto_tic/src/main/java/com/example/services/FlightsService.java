package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private PendingFlightsRepository pendingFlightsRepository;

    @Autowired
    private PlaneRepository planeRepository;
    
    @Autowired
    private AirportRepository airportRepository;


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

    public void savePlane(Plane plane){
        planeRepository.save(plane);
    }
    public boolean existPlane(String numero){
        Plane plane = planeRepository.findByNumero(numero);
        if(plane!=null){
            return true;
        }else{
            return false;
        }
    }
    public List<Plane> verTodosLosAviones(Long idAerolinea){
        return planeRepository.findByIdAirline(idAerolinea);
    }

    public Plane ComprobarAvion(String Numero,Long idAereolinea){
        return planeRepository.findByNumeroAndIdAirline(Numero, idAereolinea);
    }

    public boolean existFlight(String code) {
        return (flightsRepository.findByCode(code) != null);
    }

}
