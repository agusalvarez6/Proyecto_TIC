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
    private Button aceptar_button;

    @FXML
    void salir(ActionEvent event) {
        FxWeaver fxWeaver = Main.getContext().getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(InicioController.class);
        atras_button.getScene().setRoot(root);
    }
    String location;
    @FXML
    void aceptar(ActionEvent event) {
        Flights vueloSeleccionado = vuelosaprobados_table.getSelectionModel().getSelectedItem();
        if (vueloSeleccionado != null) {
            FxWeaver fxWeaver = Main.getContext().getBean(FxWeaver.class);
            Object controller = fxWeaver.loadController(flight_aprobationController.class);
            if (controller instanceof flight_aprobationController) {
                if(vueloSeleccionado.getOrigin().equals(Aeropuerto.getIATA())){
                    location = "Origen"; 
                }else{
                    location = "Destino";
                }
                
               ((flight_aprobationController) controller).VueloGuardado(vueloSeleccionado , location);
            }
            Parent root = fxWeaver.loadView(flight_aprobationController.class);
            aceptar_button.getScene().setRoot(root);
        } else {
            System.out.println("Por favor, selecciona un vuelo para aceptar.");

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Vuelo no seleccionado");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecciona un vuelo para aceptar.");
    
            alert.showAndWait();
        }
    }
    
    Airport Aeropuerto;
    List<Flights> vuelos;
    Long setUsuario(Long usuario){
        Aeropuerto = airportService.getAirport(usuario);
        vuelos = getVuelos();

        return usuario;
    }

    List<Flights> getVuelos(){
        List<Flights> vuelosN = new ArrayList<Flights>();
        List<Flights> vuelosO = airportService.verVuelosDeAeropuerto(Aeropuerto.getIATA(),"Origen");
        List<Flights> vuelosD = airportService.verVuelosDeAeropuerto(Aeropuerto.getIATA(),"Destino");
        for (Flights vuelo : vuelosO) {
            System.out.println(vuelo.getStateOrigin()+" "+vuelo.getCode());
            if(vuelo.getStateOrigin()==0){
                vuelosN.add(vuelo);
            }
        }
        for (Flights vuelo : vuelosD) {
            System.out.println(vuelo.getStateDestination()+" "+vuelo.getCode());
            if(vuelo.getStateDestination()==0){
                vuelosN.add(vuelo);
            }
        }
        return vuelosN;
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
        String numeroPuerta = numeropuerta_field.getText();
        if (numeroPuerta.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campo de puerta vacío");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, ingresa un número de puerta.");

            alert.showAndWait();
        } else {
            ShipmentDoor puerta = new ShipmentDoor(numeroPuerta, Aeropuerto.getIATA());
            airportService.saveShipmentDoor(puerta);

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Puerta Guardada");
            successAlert.setHeaderText(null);
            successAlert.setContentText("La puerta se ha guardado exitosamente.");

            successAlert.showAndWait();

            numeropuerta_field.setText("");
        }
    }

    @FXML
    void agregarpista(ActionEvent event) {
        String numeroPista = numeropista_field.getText();
        if (numeroPista.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campo de pista vacío");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, ingresa un número de pista.");

            alert.showAndWait();
        } else {
            LandingStrip pista = new LandingStrip(numeroPista, Aeropuerto.getIATA());
            airportService.saveLandingStrip(pista);

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Pista Guardada");
            successAlert.setHeaderText(null);
            successAlert.setContentText("La pista se ha guardado exitosamente.");

            successAlert.showAndWait();

            numeropista_field.setText("");
        }
    }

    
    @FXML
    void rechazar() {
        Flights vueloSeleccionado = vuelosaprobados_table.getSelectionModel().getSelectedItem();
        if (vueloSeleccionado != null) {
            flightsService.RechazarVuelo(vueloSeleccionado);

            vuelos = getVuelos();

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

