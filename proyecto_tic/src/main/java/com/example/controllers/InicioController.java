package com.example.controllers;

import java.io.IOException;

import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import com.example.entities.Account;

import java.io.IOException;

@Component
public class InicioController {

    @FXML
    private Button ingresar_button;

    @FXML
    private Button registrarse_button;

    @FXML
    void GoToLogIn(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/controllers/login.fxml"));
            Parent logInRoot = loader.load();

            Stage logInStage = new Stage();
            logInStage.setTitle("Log In"); // Set a title for the new window

            Scene logInScene = new Scene(logInRoot);

            logInStage.setScene(logInScene);
            logInStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void GoToSignIn(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/controllers/signin.fxml"));
            Parent signInRoot = loader.load();

            Stage signInStage = new Stage();
            signInStage.setTitle("Sign In"); // Set a title for the new window

            Scene signInScene = new Scene(signInRoot);

            signInStage.setScene(signInScene);
            signInStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
