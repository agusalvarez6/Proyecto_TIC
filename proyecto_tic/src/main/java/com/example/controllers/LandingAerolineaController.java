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
    private DatePicker datepicker;

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
    void saveFlight(ActionEvent event){
        String destino = aeropdestino_field.getText();
        String origen = aeroporigen_field.getText();
        String code = numerovuelo_field.getText();
        int state = 0;

        /*if(FlightsService.VerificarDestino(destino) && FlightsService.VerificarDestino(origen)){
            
        }*/
    }


    void initialize(String username) {
        System.out.println("username: " + username);
    }

}