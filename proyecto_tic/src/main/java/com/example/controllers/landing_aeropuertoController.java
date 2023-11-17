package com.example.controllers;

import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxmlView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.entities.Airport;
import com.example.entities.Flights;
import com.example.entities.LandingStrip;
import com.example.entities.ShipmentDoor;

import java.util.ArrayList;
import java.util.List;

import net.rgielen.fxweaver.core.FxWeaver;

import com.example.Main;
import com.example.services.AirportService;
import com.example.services.FlightsService;


@Component
@FxmlView("/com/example/controllers/landing_aeropuerto.fxml")
public class landing_aeropuertoController {

    @Autowired
    private AirportService airportService;

    @Autowired
    private FlightsService flightsService;

    @FXML
    private TableColumn<Flights, Long> aerolinea_col;

    @FXML
    private Button agregarpista_button;

    @FXML
    private Button agregarpuerta_button;

    @FXML
    private Button atras_button;

    @FXML
    private TableColumn<Flights, String> destino_col;

    @FXML
    private TableColumn<Flights, String> estado_col;

    @FXML
    private TableColumn<Flights, String> llegada_col;

    @FXML
    private Tab management_tab;

    @FXML
    private TableColumn<Flights, String> nrovuelo_col;

    @FXML
    private TextField numeropista_field;

    @FXML
    private TextField numeropuerta_field;

    @FXML
    private TableColumn<Flights, String> origen_col;

    @FXML
    private TableColumn<Flights, String> salida_col;

    @FXML
    private Tab vuelos_tab;

    @FXML
    private TableView<Flights> vuelosaprobados_table;

    @FXML
    private Button rechazar_Button;

    @FXML
    private Button aceptar_Button;

    @FXML
    void salir(ActionEvent event) {
        FxWeaver fxWeaver = Main.getContext().getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(InicioController.class);
        atras_button.getScene().setRoot(root);
    }
    
    Airport Aeropuerto;
    List<Flights> vuelos;
    Long setUsuario(Long usuario){
        Aeropuerto = airportService.getAirport(usuario);
        vuelos = airportService.verVuelosDeAeropuerto(Aeropuerto.getIATA());
        return usuario;
    }

    @FXML
    void initialize() {
        if(vuelos!=null){
            ObservableList<Flights> vuelosObs = FXCollections.observableArrayList(vuelos);

            vuelosaprobados_table.setItems(vuelosObs);


            nrovuelo_col.setCellValueFactory(new PropertyValueFactory<Flights,String>("code"));
            origen_col.setCellValueFactory(new PropertyValueFactory<Flights,String>("origin"));
            destino_col.setCellValueFactory(new PropertyValueFactory<Flights,String>("destination"));
            salida_col.setCellValueFactory(new PropertyValueFactory<Flights,String>("departure_time"));
            llegada_col.setCellValueFactory(new PropertyValueFactory<Flights,String>("arrival_time"));
            aerolinea_col.setCellValueFactory(new PropertyValueFactory<Flights,Long>("idAirline"));
            vuelosaprobados_table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        }
    }

    @FXML
    void agregarpuerta(ActionEvent event) {
        ShipmentDoor puerta = new ShipmentDoor(numeropuerta_field.getText(), Aeropuerto.getIdAirport());

        airportService.saveShipmentDoor(puerta);
        System.out.println("Puerta agregada");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Puerta Guardada");
    alert.setHeaderText(null);
    alert.setContentText("La puerta se ha guardado exitosamente.");

    alert.showAndWait();

    // Limpiar los campos de texto después de agendar el vuelo
    numeropuerta_field.setText("");

    }

    @FXML
    void agregarpista(ActionEvent event) {
        LandingStrip pista = new LandingStrip(numeropista_field.getText(), Aeropuerto.getIdAirport());

        airportService.saveLandingStrip(pista);
        System.out.println("Pista agregada");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Pista Guardada");
    alert.setHeaderText(null);
    alert.setContentText("La pista se ha guardado exitosamente.");

    alert.showAndWait();

    // Limpiar los campos de texto después de agendar el vuelo
    numeropista_field.setText("");
    
    }

    
    @FXML
    void rechazar() {
        Flights vueloSeleccionado = vuelosaprobados_table.getSelectionModel().getSelectedItem();
        if (vueloSeleccionado != null) {
            flightsService.RechazarVuelo(vueloSeleccionado);

            vuelos = airportService.verVuelosDeAeropuerto(Aeropuerto.getIATA());

            ObservableList<Flights> vuelosObs = FXCollections.observableArrayList(vuelos);
            vuelosaprobados_table.setItems(vuelosObs);

            Platform.runLater(() -> vuelosaprobados_table.refresh());
        } else {
            System.out.println("Por favor, selecciona un vuelo para rechazar.");

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Vuelo no seleccionado");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecciona un vuelo para rechazar.");
    
            alert.showAndWait();
        }
    }
    
}

