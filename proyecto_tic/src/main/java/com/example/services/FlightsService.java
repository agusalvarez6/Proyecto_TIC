package com.example.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Flights;
import com.example.entities.LandingStrip;
import com.example.entities.Plane;
import com.example.entities.ShipmentDoor;
import com.example.repository.AirportRepository;
import com.example.repository.FlightsRepository;
import com.example.repository.PlaneRepository;
import java.util.Optional;


@Service
public class FlightsService {
     
    @Autowired
    private FlightsRepository flightsRepository;

    @Autowired
    private PlaneRepository planeRepository;

    @Autowired
    private AirportService airportService;


    public Flights saveFlights(Flights flights) {
        return flightsRepository.save(flights);
    }

    public List<Flights> verTodosLosVuelos() {
        return flightsRepository.findAll();
    }

    public List<Flights> verVuelosAprobadoso(String origen, String destino) {
        return flightsRepository.findByOriginAndDestinationAndStateOriginAndStateDestination(origen, destino, 1 ,1);
    }
    
    public List<Flights> verVuelosDeAerolinea(Long idAerolinea) {
        return flightsRepository.findByIdAirline(idAerolinea);
    }
     
    public void confirmarVuelo(Flights flights,String locate) {
        if(locate=="Destino"){
            flights.setStateDestination(1);

        }else if(locate=="Origen"){
            flights.setStateOrigin(1);
        }
        flightsRepository.save(flights);
    }

    public void RechazarVuelo(Flights flights){
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

    public List<ShipmentDoor> getAvailableShipmentDoors(Flights flight, String location) {
        List<Flights> flights;
        if (location.equals("Origen")) {
            flights = flightsRepository.findByOriginAndStateOrigin(location, 1);
        } else {
            flights = flightsRepository.findByDestinationAndStateDestination(location, 1);
        }

        List<ShipmentDoor> allDoors = airportService.getShipmentDoors(location);
        List<ShipmentDoor> availableDoors = new ArrayList<>(allDoors);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        for (Flights existingFlight : flights) {
            System.out.println("Checking overlap with existing flight: " + existingFlight.getIdFlights());

            LocalDateTime currentFlightDeparture = parseDateTime(flight.getDeparture_time(), formatter);
            LocalDateTime currentFlightArrival = parseDateTime(flight.getArrival_time(), formatter);
            LocalDateTime existingFlightDeparture = parseDateTime(existingFlight.getDeparture_time(), formatter);
            LocalDateTime existingFlightArrival = parseDateTime(existingFlight.getArrival_time(), formatter);

            int turnaroundTime = 30;

            LocalDateTime currentFlightTurnaroundStart = currentFlightDeparture.minusMinutes(turnaroundTime);
            LocalDateTime currentFlightTurnaroundEnd = currentFlightArrival.plusMinutes(turnaroundTime);

            LocalDateTime existingFlightDepartureTime = existingFlightDeparture.minusMinutes(turnaroundTime);
            LocalDateTime existingFlightArrivalTime = existingFlightArrival.plusMinutes(turnaroundTime);

            if (isOverlap(currentFlightTurnaroundStart, currentFlightTurnaroundEnd, existingFlightDepartureTime, existingFlightArrivalTime)) {
                System.out.println("Overlap detected with existing flight: " + existingFlight.getIdFlights());
                System.out.println(existingFlight.getDeparture_door() + " " + existingFlight.getArrival_door());
                ShipmentDoor door;
                if (location.equals("Origen")) {
                    door = airportService.getShipmentDoor(existingFlight.getDeparture_door());
                } else {
                    door = airportService.getShipmentDoor(existingFlight.getArrival_door());
                }

                removeDoorIfPresent(availableDoors, door);
            }
        }

        System.out.println("Available Doors after processing: " + availableDoors);
        return availableDoors;
    }

    private List<Flights> getLocationFlights(String location) {
        if (location.equals("Origen")) {
            return flightsRepository.findByOriginAndStateOrigin(location, 1);
        } else {
            return flightsRepository.findByDestinationAndStateDestination(location, 1);
        }
    }

    private LocalDateTime parseDateTime(String dateTime, DateTimeFormatter formatter) {
        return LocalDateTime.parse(dateTime, formatter);
    }

    private void removeDoorIfPresent(List<ShipmentDoor> doors, ShipmentDoor doorToRemove) {
        if (doorToRemove != null) {
            System.out.println("Removing door " + doorToRemove.getNumberDoor());
            doors.removeIf(door -> door.getNumberDoor().equals(doorToRemove.getNumberDoor()));
        } else {
            System.out.println("Door is null");
        }
    }

    private boolean isOverlap(LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2) {
        System.out.println("Interval 1: " + start1 + " to " + end1);
        System.out.println("Interval 2: " + start2 + " to " + end2);
        return start1.isBefore(end2) && end1.isAfter(start2);
    }

    public List<LandingStrip> getAvailableLandingStrips(Flights flight, String location) {
        List<Flights> flights;
        if (location.equals("Origen")) {
            flights = flightsRepository.findByOriginAndStateOrigin(location, 1);
        } else {
            flights = flightsRepository.findByDestinationAndStateDestination(location, 1);
        }

        List<LandingStrip> allStrips = airportService.getLandingStrips(location);
        List<LandingStrip> availableStrips = new ArrayList<>(allStrips);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        for (Flights existingFlight : flights) {
            System.out.println("Checking overlap with existing flight: " + existingFlight.getIdFlights());

            LocalDateTime currentFlightDeparture = parseDateTime(flight.getDeparture_time(), formatter);
            LocalDateTime currentFlightArrival = parseDateTime(flight.getArrival_time(), formatter);
            LocalDateTime existingFlightDeparture = parseDateTime(existingFlight.getDeparture_time(), formatter);
            LocalDateTime existingFlightArrival = parseDateTime(existingFlight.getArrival_time(), formatter);

            int turnaroundTime = 30;

            LocalDateTime currentFlightTurnaroundStart = currentFlightDeparture.minusMinutes(turnaroundTime);
            LocalDateTime currentFlightTurnaroundEnd = currentFlightArrival.plusMinutes(turnaroundTime);

            LocalDateTime existingFlightDepartureTime = existingFlightDeparture.minusMinutes(turnaroundTime);
            LocalDateTime existingFlightArrivalTime = existingFlightArrival.plusMinutes(turnaroundTime);

            if (isOverlap(currentFlightTurnaroundStart, currentFlightTurnaroundEnd, existingFlightDepartureTime, existingFlightArrivalTime)) {
                System.out.println("Overlap detected with existing flight: " + existingFlight.getIdFlights());
                System.out.println(existingFlight.getDeparture_LandingStrip() + " " + existingFlight.getArrival_LandingStrip());
                LandingStrip strip;
                if (location.equals("Origen")) {
                    strip = airportService.getLandingStrip(existingFlight.getDeparture_LandingStrip());
                } else {
                    strip = airportService.getLandingStrip(existingFlight.getArrival_LandingStrip());
                }

                removeStripIfPresent(availableStrips, strip);
            }
        }

        System.out.println("Available Strips after processing: " + availableStrips);
        return availableStrips;
    }

    private void removeStripIfPresent(List<LandingStrip> strips, LandingStrip stripToRemove) {
        if (stripToRemove != null) {
            System.out.println("Removing strip " + stripToRemove.getNumberLandingStrip());
            strips.removeIf(strip -> strip.getNumberLandingStrip().equals(stripToRemove.getNumberLandingStrip()));
        } else {
            System.out.println("Strip is null");
        }
    }
}

    


