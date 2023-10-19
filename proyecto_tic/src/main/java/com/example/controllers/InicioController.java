package com.example.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

import com.example.Main;
import com.example.entities.Account;

import java.io.IOException;

@Component
@FxmlView("/com/example/controllers/inicio.fxml")
public class InicioController {

    @FXML
    private Button ingresar_button;

    @FXML
    private Button registrarse_button;

    @FXML
    void GoToLogIn(ActionEvent event) {
            
            FxWeaver fxWeaver = Main.getContext().getBean(FxWeaver.class);
            Parent root = fxWeaver.loadView(LogInController.class);
            ingresar_button.getScene().setRoot(root);
    }

    @FXML
    void GoToSignIn(ActionEvent event) {
        FxWeaver fxWeaver = Main.getContext().getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(SignInController.class);
        ingresar_button.getScene().setRoot(root);
            
    }
}
