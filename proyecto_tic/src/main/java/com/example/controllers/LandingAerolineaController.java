package com.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxmlView;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

import com.example.Main;
import com.example.entities.Account;
import com.example.entities.Airline;
import com.example.entities.Airport;
import com.example.entities.Flights;
import com.example.entities.Plane;
import com.example.services.AccountService;
import com.example.services.AirlineService;
import com.example.services.AirportService;
import com.example.services.FlightsService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component
@FxmlView("/com/example/controllers/landing_aerolinea.fxml")
public class LandingAerolineaController {

   
    @FXML
    private TextField aeropdestino_field;

    @FXML
    private TextField aeroporigen_field;

    @FXML
    private Button agendarvuelo_button;

    @FXML
    private Tab agendarvuelo_tab;

    @FXML
    private Button agregaravion_button;

    @FXML
    private Tab agregaravion_tab;

    @FXML
    private Button atras_button;

    @FXML
    private TextField capacidadavion_field;

    @FXML
    private TextField aeropincial_field;

    @FXML
    private TextField salida_field;

    @FXML
    private TextField llegada_field;

    @FXML
    private TableColumn<Flights, String> destino_col;

    @FXML
    private TextField horallegada_field;

    @FXML
    private TextField horasalida_field;

    @FXML
    private TableColumn<Flights, String> llegada_col;

    @FXML
    private TextField nroavion_field;

    @FXML
    private TextField numeroavion_field;

    @FXML
    private TableColumn<Flights, String> numerovuelo_col;

    @FXML
    private TextField numerovuelo_field;

    @FXML
    private TableColumn<Flights, String> origen_col;

    @FXML
    private TableColumn<Flights, String> salida_col;

    @FXML
    private Tab vuelosagendados_tab;

    @FXML
    private TableView<Flights> vuelosagendados_table;

    @Autowired
    private FlightsService flightsService;

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AirportService airportService;

    Long id;

    void initialize(String username) {
        id = accountService.getAccount(username).getIdAccount();
        System.out.println("username: " + username+ " id: "+id);
    }

    @FXML
    void salir(ActionEvent event) {
        FxWeaver fxWeaver = Main.getContext().getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(InicioController.class);
        atras_button.getScene().setRoot(root);
    }

    @FXML
    void saveFlight(ActionEvent event){
        int state = 0;
        Flights vuelo = new Flights();

        vuelo.setCode(numerovuelo_field.getText());
        vuelo.setDestination(aeropdestino_field.getText());
        vuelo.setOrigin(aeroporigen_field.getText());
        vuelo.setArrival_time(llegada_field.getText());
        vuelo.setDeparture_time(salida_field.getText());
        vuelo.setState(0);
        vuelo.setIdAirline(id);
        //vuelo.setIdPlane(nroavion_field.getText());
        Plane avion = flightsService.ComprobarAvion(nroavion_field.getText(), id);
        if (avion==null){
            System.out.println("Avion no encontrado");
            return;
        }
        if (flightsService.existFlight(vuelo.getCode())==true){
            System.out.println("Vuelo ya existente");
            return;
        }
        if (airportService.existAirport(vuelo.getOrigin())==false){
            System.out.println("Aeropuerto de origen no encontrado");
            return;
        }
        if (airportService.existAirport(vuelo.getDestination())==false){
            System.out.println("Aeropuerto de destino no encontrado");
            return;
        }
        LocalDateTime departureTime = LocalDateTime.parse(vuelo.getDeparture_time(), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        LocalDateTime arrivalTime = LocalDateTime.parse(vuelo.getArrival_time(), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        if (departureTime.isAfter(arrivalTime)){
            System.out.println("Horario no valido");
            return;
        }
        Flights vueloGuardado = flightsService.saveFlights(vuelo);
        System.out.println("Todo anda bien");
    } 

    
    @FXML
    void initialize(Long username) {
        id = airlineService.getAirlineId(username);
        System.out.println("username: " + username+ " id: "+id);
        ObservableList<Flights> vuelosObs = FXCollections.observableArrayList(
                new Flights(1L,"BUE","MIA","2021-06-01 10:00:00","2021-06-01 15:00:00","AA123"),
                new Flights(1L,"MIA","BUE","2021-06-01 16:00:00","2021-06-01 21:00:00","AA124"),
                new Flights(1L,"BUE","MIA","2021-06-02 10:00:00","2021-06-02 15:00:00","AA125")
            );
    
            numerovuelo_col.setCellValueFactory(new PropertyValueFactory<Flights,String>("code"));
            origen_col.setCellValueFactory(new PropertyValueFactory<Flights,String>("origin"));
            destino_col.setCellValueFactory(new PropertyValueFactory<Flights,String>("destination"));
            salida_col.setCellValueFactory(new PropertyValueFactory<Flights,String>("departure_time"));
            llegada_col.setCellValueFactory(new PropertyValueFactory<Flights,String>("arrival_time"));
            vuelosagendados_table.setItems(vuelosObs);
            vuelosagendados_table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    void savePlane(ActionEvent event){
        Plane avion = new Plane();
        avion.setCapacity(capacidadavion_field.getText());
        avion.setIdAirline(id);
        avion.setNumero(numeroavion_field.getText());
        if (flightsService.existPlane(avion.getNumero())==false){
            flightsService.savePlane(avion);
            System.out.println("Avion guardado");
        }
        else{
            System.out.println("Numero ya existente");
        }        
        printAviones();
    }
    private void printAviones(){
        System.out.println("Todos los aviones registrados: ");
        for (Plane avion : flightsService.verTodosLosAviones(id)) {
            System.out.println(avion.getIdPlane()+" "+avion.getNumero()+" "+avion.getCapacity()+" "+avion.getIdAirline());
        }
    }

}