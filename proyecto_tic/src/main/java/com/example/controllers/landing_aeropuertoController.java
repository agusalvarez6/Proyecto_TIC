package com.example.controllers;

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
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import com.example.entities.Account;
import java.io.IOException;
import net.rgielen.fxweaver.core.FxWeaver;

import com.example.Main;
import com.example.entities.Account;
import com.example.services.AccountService;

@Component
@FxmlView("/com/example/controllers/landing_aeropuerto.fxml")
public class landing_aeropuertoController {

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
    private TableView<?> vuelosaprobados_table;

}
