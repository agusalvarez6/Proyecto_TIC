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
    ShipmentDoorRepository shipmentDoorRepository;

    @Autowired
    LandingStripRepository landingStripRepository;

    @Autowired
    private FlightsRepository flightsRepository;

    public Airport saveAirport(Airport airport) {
        if (airportRepository.findByiATA(airport.getIATA()) == null) {
            return airportRepository.save(airport);
        }
        return null;
    }

    public boolean VerificarDestino(String IATA){
        return (airportRepository.findByiATA(IATA) != null);
    }

     public List<Flights> verVuelosDeAeropuerto(String idAeropuerto, String location) {
        if(location.equals("Origen")){
            return flightsRepository.findByOriginAndStateOrigin(idAeropuerto,0);
        }else{
            return flightsRepository.findByDestinationAndStateDestination(idAeropuerto,0);
        }
    }

    public Airport getAirport(Long idAccount){
        Airport aeropuerto = airportRepository.findByIdAccount(idAccount);
        if(aeropuerto!=null){
            return aeropuerto;
        }else{
            return null;
        }
    }

    public boolean existAirport(String IATA){
        return (airportRepository.findByiATA(IATA) != null);
    }

    public Airport getAirport(String IATA){
        return airportRepository.findByiATA(IATA);
    }

    public void saveShipmentDoor(ShipmentDoor shipmentDoor) {
        shipmentDoorRepository.save(shipmentDoor);
    }

    public void saveLandingStrip(LandingStrip landingStrip) {
        landingStripRepository.save(landingStrip);
    }

    public List<ShipmentDoor> getShipmentDoors(String IATA) {
        return shipmentDoorRepository.findByIdAirport(IATA);
    }

    public List<LandingStrip> getLandingStrips(String IATA) {
        return landingStripRepository.findByIdAirport(IATA);
    }

    public ShipmentDoor getShipmentDoor(Long id) {
        return shipmentDoorRepository.findByIdDoor(id);
    }

    public LandingStrip getLandingStrip(Long id) {
        return landingStripRepository.findByIdLandingStrip(id);
    }
}
