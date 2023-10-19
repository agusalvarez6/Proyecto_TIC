package com.example.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.IOException;
import org.springframework.stereotype.Component;
@Component
public class adminController {

    @FXML
    private Button buscarusuarios_button;

    @FXML
    private TextField buscarusuarios_field;

    @FXML
    private TextField ciudadaeropuerto_field;

    @FXML
    private TextField codigoiata_field;

    @FXML
    private TextField contrasenaaerolinea_field;

    @FXML
    private TextField contrasenaaeropuerto_field;

    @FXML
    private TextField contrasenaempleado_field;

    @FXML
    private TextField contrasenalocal_field;

    @FXML
    private Tab crearaeroli_tab;

    @FXML
    private Tab crearaerop_tab;

    @FXML
    private Tab crearempleado_tab;

    @FXML
    private Tab crearlocal_tab;

    @FXML
    private TextField iatalocal_field;

    @FXML
    private Button ingresaraerolinea_button;

    @FXML
    private Button ingresaraeropuerto_button;

    @FXML
    private Button ingresarempleado_field;

    @FXML
    private Button ingresarlocal_field;

    @FXML
    private TextArea mostrarusuarios_area;

    @FXML
    private TextField nameaerolinea_field;

    @FXML
    private TextField nameaeropuerto_field;

    @FXML
    private TextField nameempleado_field;

    @FXML
    private TextField namelocal_field;

    @FXML
    private TextField paisaeropuerto_field;

    @FXML
    private TextField rolempleado_field;

    @FXML
    private TextField sueldoempleado_field;

    @FXML
    private TextField tipolocal_field;

    @FXML
    private TextField usuarioaerolinea_field;

    @FXML
    private TextField usuarioempleado_field;

    @FXML
    private TextField usuariolocal_field;

    @FXML
    private Tab verusuarios_tab;

}
