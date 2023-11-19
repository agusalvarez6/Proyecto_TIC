package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.spring.SpringFxWeaver;

import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.entities.Account;
import com.example.entities.Airline;
import com.example.entities.Airport;
import com.example.repository.AccountRepository;
import com.example.services.AccountService;
import com.example.services.AirlineService;
import com.example.repository.AirportRepository;
import com.example.services.AirportService;

import jakarta.annotation.PostConstruct;



@SpringBootApplication
public class Main {
    private static ConfigurableApplicationContext context;


    public static void main(String[] args) {

        Main.context = SpringApplication.run(Main.class);
        Application.launch(App.class, args);
    }
    public static ConfigurableApplicationContext getContext() {
        return context;
    }
    @Bean
    public FxWeaver fxWeaver(ConfigurableApplicationContext applicationContext) {
        return new SpringFxWeaver(applicationContext);
    }


    // Crea un usuario administrador por defecto
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AirportService airportService;
    @Autowired
    private AirlineService airlineService;

    @PostConstruct
    public void initializeUsers() {
        // Administrador
        if (accountRepository.findByUsername("admin") == null) {
            Account nuevoUsuario = new Account();
            nuevoUsuario.setUsername("admin");
            nuevoUsuario.setPassword("admin");
            nuevoUsuario.setRole("admin");
            Account usuarioGuardado = accountService.saveAccount(nuevoUsuario);
            if (usuarioGuardado != null) {
                System.out.println("admin created");
            }
        }
        /* 
        // Usuario de prueba
        if (accountRepository.findByUsername("usuario") == null) {
            Account nuevoUsuario = new Account();
            nuevoUsuario.setUsername("usuario");
            nuevoUsuario.setPassword("usuario");
            nuevoUsuario.setRole("usuario");
            Account usuarioGuardado = accountService.saveAccount(nuevoUsuario);

            if (usuarioGuardado != null) {
                System.out.println("usuario created");
            }
        }
        // Aerolinea de prueba
        if (accountRepository.findByUsername("aerolinea") == null) {
            Account nuevoUsuario = new Account();
            nuevoUsuario.setUsername("aerolinea");
            nuevoUsuario.setPassword("aerolinea");
            nuevoUsuario.setRole("aerolinea");
            Account usuarioGuardado = accountService.saveAccount(nuevoUsuario);

            if (usuarioGuardado != null) {
                System.out.println("usuario aerolinea created");
                Airline newAirline = new Airline();
                newAirline.setName("aerolinea prueba");
                newAirline.setIdAccount(usuarioGuardado.getIdAccount());
                Airline airlineGuardado = airlineService.saveAirline(newAirline);
                if (airlineGuardado != null) {
                    System.out.println("entidad aerolinea created");
                } else {
                    // Ocurrió un error al guardar el usuario, muestra un mensaje de error o realiza alguna acción apropiada.
                }
                
            }
        }
        // Aeropuerto de prueba
        if (accountRepository.findByUsername("aeropuerto") == null) {
            Account nuevoUsuario = new Account();
            nuevoUsuario.setUsername("aeropuerto");
            nuevoUsuario.setPassword("aeropuerto");
            nuevoUsuario.setRole("aeropuerto");
            Account usuarioGuardado = accountService.saveAccount(nuevoUsuario);

            if (usuarioGuardado != null) {
                System.out.println("usuario aeropuerto created");
                Airport newAirport = new Airport();
                newAirport.setName("aeropuerto prueba");
                newAirport.setCity("city prueba");
                newAirport.setCountry("country prueba");
                newAirport.setIATA("IATA");
                newAirport.setIdAccount(usuarioGuardado.getIdAccount());
                Airport airportGuardado = airportService.saveAirport(newAirport);
                if (airportGuardado != null) {
                    System.out.println("entidad aeropuerto created");
                } else {
                    // Ocurrió un error al guardar el usuario, muestra un mensaje de error o realiza alguna acción apropiada.
                }
            }
        }
        */      
    }
}
