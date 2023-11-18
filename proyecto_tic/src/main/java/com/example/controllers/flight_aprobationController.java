package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entities.Flights;
import com.example.entities.LandingStrip;
import com.example.entities.ShipmentDoor;
import com.example.services.AirportService;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("/com/example/controllers/flight_aprobation.fxml")
public class flight_aprobationController {

    @Autowired
    private AirportService airportService;

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
                pistas = airportService.getLandingStrips(vuelo.getOrigin());
                puertas = airportService.getShipmentDoors(vuelo.getOrigin());
            }else{
                pistas = airportService.getLandingStrips(vuelo.getDestination());
                puertas = airportService.getShipmentDoors(vuelo.getDestination());
            }
            ObservableList<LandingStrip> pistasObs = FXCollections.observableArrayList(pistas);
            pistas_table.setItems(pistasObs);
            pista_column.setCellValueFactory(new PropertyValueFactory<>("numberLandingStrip"));
            
            ObservableList<ShipmentDoor> puertasObs = FXCollections.observableArrayList(puertas);
            puertas_table.setItems(puertasObs);
            puerta_column.setCellValueFactory(new PropertyValueFactory<>("numberDoor"));
        }
    }
}
