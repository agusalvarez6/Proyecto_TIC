package com.example.services;

import com.example.entities.*;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineService {
    @Autowired
    AirlineRepository airlineRepository;

    public Airline saveAirline(Airline airline) {
        if (airlineRepository.findByName(airline.getName()) == null) {
            return airlineRepository.save(airline);
        }
        return null;
    }

    public Airline getAirlineId(Long idAccount){
        Airline aerolinea = airlineRepository.findByIdAccount(idAccount);
        if(aerolinea!=null){
            return aerolinea;
        }else{
            return null;
        }
    }


}
