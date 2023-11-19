package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Main;
import com.example.entities.Flights;
import com.example.entities.LandingStrip;
import com.example.entities.ShipmentDoor;
import com.example.services.AirportService;
import com.example.services.FlightsService;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("/com/example/controllers/flight_aprobation.fxml")
public class flight_aprobationController {

    @Autowired
    private AirportService airportService;

    @Autowired
    private FlightsService flightsService;

    @FXML
    private TableColumn<?, ?> aerolinea_column;
    @FXML
    private TableColumn<?, ?> destino_column;

    @FXML
    private TableColumn<?, ?> llegada_column;

    @FXML
    private TableColumn<?, ?> nrovuelo_column;

    @FXML
    private TableColumn<?, ?> origen_column;

    @FXML
    private TableColumn<LandingStrip, String> pista_column;

    @FXML
    private TableView<LandingStrip> pistas_table;

    @FXML
    private TableColumn<ShipmentDoor, String> puerta_column;

    @FXML
    private TableView<ShipmentDoor> puertas_table;

    @FXML
    private Button reservar_button;

    @FXML
    private TableColumn<?, ?> salida_column;

    @FXML
    private TableView<Flights> vuelo_table;

    @FXML
    private Button atras_button;

    Flights vuelo;
    String Location;
    Flights VueloGuardado(Flights vueloAprob, String location){
        if(vueloAprob==null){
            System.out.println("Vuelo nulo");
        }
        Location = location;
        vuelo = vueloAprob;
        return vuelo;
    }

    @FXML
    void initialize(){
        if (vuelo != null) {
            ObservableList<Flights> vuelosObs = FXCollections.observableArrayList(vuelo);

            vuelo_table.setItems(vuelosObs);
            nrovuelo_column.setCellValueFactory(new PropertyValueFactory<>("code"));
            aerolinea_column.setCellValueFactory(new PropertyValueFactory<>("idAirline"));
            origen_column.setCellValueFactory(new PropertyValueFactory<>("origin"));
            destino_column.setCellValueFactory(new PropertyValueFactory<>("destination"));
            llegada_column.setCellValueFactory(new PropertyValueFactory<>("arrival_time"));
            salida_column.setCellValueFactory(new PropertyValueFactory<>("departure_time"));
            List<LandingStrip> pistas;
            List<ShipmentDoor> puertas;
            if(Location=="Origen"){
                pistas = flightsService.getAvailableLandingStrips(vuelo,vuelo.getOrigin());
                puertas = flightsService.getAvailableShipmentDoors(vuelo,vuelo.getOrigin());
            }else{
                pistas = flightsService.getAvailableLandingStrips(vuelo,vuelo.getDestination());
                puertas = flightsService.getAvailableShipmentDoors(vuelo,vuelo.getDestination());
            }
            ObservableList<LandingStrip> pistasObs = FXCollections.observableArrayList(pistas);
            pistas_table.setItems(pistasObs);
            pista_column.setCellValueFactory(new PropertyValueFactory<>("numberLandingStrip"));
            pistas_table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            
            ObservableList<ShipmentDoor> puertasObs = FXCollections.observableArrayList(puertas);
            puertas_table.setItems(puertasObs);
            puerta_column.setCellValueFactory(new PropertyValueFactory<>("numberDoor"));
            puertas_table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        }
    }

    @FXML
    void reservar() {
        System.out.println("Reservar");
        ShipmentDoor doorSeleccionado = puertas_table.getSelectionModel().getSelectedItem();
        LandingStrip pistaSeleccionado = pistas_table.getSelectionModel().getSelectedItem();
        if (doorSeleccionado != null && pistaSeleccionado != null) {
            System.out.println("Reservado2");
            if (Location == "Origen") {
                System.out.println("Reservado3");
                vuelo.setDeparture_door(doorSeleccionado.getIdDoor());
                vuelo.setDeparture_LandingStrip(pistaSeleccionado.getIdLandingStrip());
            } else {
                System.out.println("Reservado4");
                vuelo.setArrival_door(doorSeleccionado.getIdDoor());
                vuelo.setArrival_LandingStrip(pistaSeleccionado.getIdLandingStrip());
            }
            flightsService.confirmarVuelo(vuelo, Location);
        }
        System.out.println(vuelo.getDeparture_door() + " " + vuelo.getArrival_door() + " " + vuelo.getDeparture_LandingStrip() + " " + vuelo.getArrival_LandingStrip()); 
    }

    @FXML
    void salir(ActionEvent event) {
        FxWeaver fxWeaver = Main.getContext().getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(InicioController.class);
        atras_button.getScene().setRoot(root);
    }
}
