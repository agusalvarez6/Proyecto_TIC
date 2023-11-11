package com.example.controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.entities.Airport;
import com.example.entities.PendingFlights;

import java.io.IOException;
import java.util.List;

import net.rgielen.fxweaver.core.FxWeaver;

import com.example.Main;
import com.example.services.AirportService;

@Component
@FxmlView("/com/example/controllers/landing_aeropuerto.fxml")
public class landing_aeropuertoController {

    @Autowired
    private AirportService airportService;

    @FXML
    private TableColumn<?, ?> aerolinea_col;

    @FXML
    private Button agregarpista_button;

    @FXML
    private Button agregarpuerta_button;

    @FXML
    private Tab asignarpuertas_tab;

    @FXML
    private TableView<?> asignarpuertas_table;

    @FXML
    private Button atras_button;

    @FXML
    private TableColumn<?, ?> destino_col;

    @FXML
    private TableColumn<?, ?> estado_col;

    @FXML
    private TableColumn<?, ?> llegada_col;

    @FXML
    private Tab management_tab;

    @FXML
    private TableColumn<?, ?> nrovuelo_col;

    @FXML
    private TextField numeropista_field;

    @FXML
    private TextField numeropuerta_field;

    @FXML
    private TableColumn<?, ?> numerovuelo_col;

    @FXML
    private TableColumn<?, ?> origen_col;

    @FXML
    private TableColumn<?, ?> pista_col;

    @FXML
    private TableColumn<?, ?> puerta_col;

    @FXML
    private TableColumn<?, ?> salida_col;

    @FXML
    private Tab vuelos_tab;

    @FXML
    private TableView<PendingFlights> vuelosaprobados_table;

    @FXML
    void salir(ActionEvent event) {
        FxWeaver fxWeaver = Main.getContext().getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(InicioController.class);
        atras_button.getScene().setRoot(root);
    }
    
    Airport Aeropuerto;
    
    void initialize(Long idAccount) {
        Aeropuerto = airportService.getAirport(idAccount);
        List<PendingFlights> vuelos = airportService.verVuelosDeAeropuerto(Aeropuerto.getIATA());
        ObservableList<PendingFlights> vuelosObs = FXCollections.observableArrayList(vuelos);

        // Asigna los datos a la tabla
        vuelosaprobados_table.setItems((ObservableList<PendingFlights>) vuelosObs);

        // Vincula las propiedades de PendingFlights a las columnas
        //numerovuelo_col.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getIdPendingFlights()));

    }
}

