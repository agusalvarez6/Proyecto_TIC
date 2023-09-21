package com.example.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.DataBase;

public class SignInController  {
    /* 
    @FXML
    private AnchorPane welcomePane;

    @FXML
    private Text welcomeText;

    @FXML
    private ImageView logoImageView;

    @FXML
    private Pane loginPane;
    */

    @FXML
    private TextField usuario_signin_field;

    @FXML
    private PasswordField contrasena1_signin_field;

    @FXML
    private PasswordField contrasena2_signin_field;

    @FXML
    private Button crearCuentaButton;
    /*
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomePane.setStyle("-fx-background-color: #2C2C2C");
        loginPane.setStyle("-fx-background-color: #2C2C2C");
        welcomeText.setStyle("-fx-fill: #FFFFFF");
        usuarioTextField.setStyle("-fx-background-color: #FFFFFF");
        contrasenaPasswordField.setStyle("-fx-background-color: #FFFFFF");
        confirmContrasenaPasswordField.setStyle("-fx-background-color: #FFFFFF");
        crearCuentaButton.setStyle("-fx-background-color: #FFFFFF");
    }
    */

    @FXML
    protected void crearCuenta() throws Exception {
        String usuario = usuario_signin_field.getText();
        String contrasena = contrasena1_signin_field.getText();
        String confirmContrasena = contrasena2_signin_field.getText();
        if (contrasena.equals(confirmContrasena)) {
            DataBase.save(usuario, contrasena);
            usuario_signin_field.clear();
            contrasena1_signin_field.clear();
            contrasena2_signin_field.clear();
            DataBase.print();
        }
    }
}