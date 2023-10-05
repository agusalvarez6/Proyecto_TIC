package com.example.controllers;

import com.example.entities.Account;
import com.example.services.AccountService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// import static jdk.nashorn.internal.objects.Global.print;

@Component
public class SignInController {
    @Autowired
    AccountService accountService;
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
        Account account = new Account();
        String usuario = usuario_signin_field.getText();
        String contrasena = contrasena1_signin_field.getText();
        String confirmContrasena = contrasena2_signin_field.getText();
        if (contrasena.equals(confirmContrasena)) {
            account.setUsername(usuario);
            account.setPassword(contrasena);
            account.setRole("Client");
            accountService.saveAccount(account);
        }
    }

}