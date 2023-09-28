package com.example.controllers;

import com.example.entities.User;
import com.example.services.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignInController {
    @Autowired
    UserService userService;
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
    public void saveUser(javafx.event.ActionEvent actionEvent)  {
        User user = new User();
        String usuario = usuario_signin_field.getText();
        String contrasena = contrasena1_signin_field.getText();
        String confirmContrasena = contrasena2_signin_field.getText();
        if (contrasena.equals(confirmContrasena)) {
            user.setUsername(usuario);
            user.setPassword(contrasena);
            user.setRole("Client");
            userService.saveUser(user);

        }
    }

}