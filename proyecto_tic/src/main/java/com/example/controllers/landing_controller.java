package com.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;

import org.springframework.stereotype.Component;

import com.example.entities.Account;

import java.io.IOException;

@Component
@FxmlView("/com/example/controllers/landing_page.fxml")
public class landing_controller {

    @FXML
    private MenuItem action2_bttn;

    @FXML
    private MenuItem action3_bttn;

    @FXML
    private TextField cantidad_field;

    @FXML
    private TextField destino_field;

    @FXML
    private MenuItem misvuelos_button;

    @FXML
    private MenuButton operaciones_menu;

    @FXML
    private TextField origen_field;

    @FXML
    private Button reservar_button;

    @FXML
    private DatePicker retorno_field;

    @FXML
    private DatePicker salida_field;

    @FXML
    void login_try(ActionEvent event) {

    }

}
