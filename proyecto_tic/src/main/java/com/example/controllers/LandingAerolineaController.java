package com.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;

import java.io.IOException;
import org.springframework.stereotype.Component;

import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

import com.example.Main;
import com.example.entities.Account;
import com.example.entities.Flights;
import com.example.services.AccountService;
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
    private TextField salida_field;

    @FXML
    private TextField llegada_field;

    @FXML
    private TableColumn<?, ?> destino_col;

    @FXML
    private TableColumn<?, ?> estadovuelo_col;

    @FXML
    private TextField horallegada_field;

    @FXML
    private TextField horasalida_field;

    @FXML
    private TableColumn<?, ?> llegada_col;

    @FXML
    private TextField nroavion_field;

    @FXML
    private TextField numeroavion_field;

    @FXML
    private TableColumn<?, ?> numerovuelo_col;

    @FXML
    private TextField numerovuelo_field;

    @FXML
    private TableColumn<?, ?> origen_col;

    @FXML
    private TableColumn<?, ?> salida_col;

    @FXML
    private Tab vuelosagendados_tab;

    @FXML
    private TableView<?> vuelosagendados_table;

    @FXML
    void salir(ActionEvent event) {
        FxWeaver fxWeaver = Main.getContext().getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(InicioController.class);
        atras_button.getScene().setRoot(root);
    }
    /*void saveFlight(ActionEvent event){
        int state = 0;
        Flights vuelo  = new Flights();
        
        vuelo.setDestination(aeropdestino_field.getText());
        vuelo.setOrigin(aeroporigen_field.getText());
        vuelo.setArrival_time(llegada_field.getText());
        
        
        vuelo.setCode(numerovuelo_field.getText());
        vuelo.setArrival_time(llegada_field.getText());
        
        vuelo.setDeparture_time(salida_field.getText());
        Plane avion = FlightsService.getPlane(nroavion_field.getText(), );
        vuelo.setIdPlane(nroavion_field.getText());
        vuelo.setState(0);
        if(FlightsService.VerificarDestino(destino) && FlightsService.VerificarDestino(origen)){
            
        }
    } */

    Long id;
    void initialize(String username) {
        System.out.println("username: " + username);
    }

}