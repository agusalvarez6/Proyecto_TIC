package com.example.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import java.io.IOException;
import org.springframework.stereotype.Component;
@Component

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
    private Tab agregaravion_tab;

    @FXML
    private DatePicker datepicker;

    @FXML
    private TextField horallegada_field;

    @FXML
    private TextField horasalida_field;

    @FXML
    private TextField numeroavion_field;

    @FXML
    private TextField puertallegada_field;

    @FXML
    private TextField puertasalida_field;

    @FXML
    private Tab vuelosagendados_tab;

}
