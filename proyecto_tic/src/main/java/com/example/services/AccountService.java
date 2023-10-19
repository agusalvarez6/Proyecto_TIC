package com.example.services;

import com.example.entities.*;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private AirportEmployeeRepository airportEmployeeRepository;

    @Autowired
    private ShopRepository shopRepository;

    public Account saveAccount(Account account) {
        if (accountRepository.findByUsername(account.getUsername()) == null) {
            return accountRepository.save(account);
        }
        return null;
    }

    public Account userAuthentication(String username, String password) {
        Account account = accountRepository.findByUsername(username);

        if (account != null && account.getPassword().equals(password)) {
            return account;
        }

        return null;
    }

    public Airline saveAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public AirportEmployee registerAirportEmployee(AirportEmployee airportEmployee) {
        return airportEmployeeRepository.save(airportEmployee);
    }

    public Shop registerShop(Shop shop) {
        return shopRepository.save(shop);
    }
}
