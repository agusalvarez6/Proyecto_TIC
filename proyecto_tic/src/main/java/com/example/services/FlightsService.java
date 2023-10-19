package com.example.services;

import com.example.entities.*;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightsService {
    @Autowired
    FlightsRepository flightsRepository;

    public Flights saveFlights(Flights flights) {
        return flightsRepository.save(flights);
    }
    public List<Flights> verTodosLosVuelos() {
        return flightsRepository.findAll();
    }
    public List<Flights> verVuelosAprobadosDesdeOrigenADestino(String origen, String destino) {
        return flightsRepository.findByOriginAndDestinationAndState(origen, destino, 1);
    }
    public List<Flights> verVuelosDeAeropuerto(Long idAeropuerto) {
        return flightsRepository.findByOriginOrDestination(idAeropuerto, idAeropuerto);
    }
    public List<Flights> verVuelosDeAerolinea(Long idAerolinea) {
        return flightsRepository.findByIdAirline(idAerolinea);
    }
    public Flights confirmarVuelo(Long vueloId) {
        Flights vuelo = flightsRepository.findById(vueloId).orElse(null);
        if (vuelo != null) {
            // Cambiar el estado del vuelo (por ejemplo, de "pendiente" a "confirmado")
            vuelo.setState(1); // Suponiendo que 1 representa "confirmado"
            return flightsRepository.save(vuelo);
        }
        return null; // Vuelo no encontrado
    }

}