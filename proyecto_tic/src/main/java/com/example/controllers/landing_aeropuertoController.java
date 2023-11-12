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
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxmlView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.entities.Airport;
import com.example.entities.Flights;
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
    private TableColumn<Flights, Long> aerolinea_col;

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
    private TableColumn<Flights, String> numerovuelo_col;

    @FXML
    private TableColumn<Flights, String> origen_col;

    @FXML
    private TableColumn<Flights, String> pista_col;

    @FXML
    private TableColumn<Flights, String> puerta_col;

    @FXML
    private TableColumn<Flights, String> salida_col;

    @FXML
    private Tab vuelos_tab;

    @FXML
    private TableView<Flights> vuelosaprobados_table;

    @FXML
    void salir(ActionEvent event) {
        FxWeaver fxWeaver = Main.getContext().getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(InicioController.class);
        atras_button.getScene().setRoot(root);
    }
    
    Airport Aeropuerto;

    @FXML
    void initialize(Long idAccount) {
        Aeropuerto = airportService.getAirport(idAccount);
        List<Flights> vuelos = airportService.verVuelosDeAeropuerto(Aeropuerto.getIATA());
        ObservableList<Flights> vuelosObs = FXCollections.observableArrayList(vuelos);

        vuelosaprobados_table.setItems(vuelosObs);

        numerovuelo_col.setCellValueFactory(new PropertyValueFactory<>("code"));
        origen_col.setCellValueFactory(new PropertyValueFactory<>("origin"));
        destino_col.setCellValueFactory(new PropertyValueFactory<>("destination"));
        salida_col.setCellValueFactory(new PropertyValueFactory<>("departure_time"));
        llegada_col.setCellValueFactory(new PropertyValueFactory<>("arrival_time"));
        aerolinea_col.setCellValueFactory(new PropertyValueFactory<>("idAirline"));
        
        vuelosaprobados_table.refresh();

    }
}

