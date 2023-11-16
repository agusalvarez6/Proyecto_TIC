package com.example.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class flight_aprobationController {

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
    private TableColumn<?, ?> pista_column;

    @FXML
    private TableView<?> pistas_table;

    @FXML
    private TableColumn<?, ?> puerta_column;

    @FXML
    private TableView<?> puertas_table;

    @FXML
    private Button reservar_button;

    @FXML
    private TableColumn<?, ?> salida_column;

    @FXML
    private TableView<?> vuelo_table;

}
