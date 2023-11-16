package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

import com.example.Main;
import com.example.entities.Account;
import com.example.services.AccountService;

@Component
@FxmlView("/com/example/controllers/signIn.fxml")
public class SignInController {

    @FXML
    private PasswordField contrasena1_signin_field;

    @FXML
    private PasswordField contrasena2_signin_field;

    @FXML
    private Button signin_button;

    @FXML
    private Button tengo_cuenta_button;

    @FXML
    private TextField usuario_signin_field;

    @FXML
    private TextField pasaporte_signin_field;

    @Autowired
    private AccountService accountService;
    
    @FXML
    void salir(ActionEvent event) {
        FxWeaver fxWeaver = Main.getContext().getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(InicioController.class);
        tengo_cuenta_button.getScene().setRoot(root);
    }
    
    @FXML
    void saveUser(ActionEvent event) {
        String username = usuario_signin_field.getText();
        String password = contrasena1_signin_field.getText();

        if(accountService.existAccount(username)){
            System.out.println("Nombre de usuario no valido");// Muestra un mensaje de error o realiza alguna acción apropiada.
            return;
        }
        
        // Verifica que las contraseñas coincidan (puedes agregar más validaciones si es necesario)
        if (!password.equals(contrasena2_signin_field.getText())) {
            // Muestra un mensaje de error o realiza alguna acción apropiada.
            return;
        }

        // Crea un nuevo objeto de usuario
        Account nuevoUsuario = new Account();
        nuevoUsuario.setUsername(username);
        nuevoUsuario.setPassword(password);
        nuevoUsuario.setRole("usuario");
        nuevoUsuario.setPassport(pasaporte_signin_field.getText());
        // Llama al servicio para guardar el usuario
        Account usuarioGuardado = accountService.saveAccount(nuevoUsuario);

        if (usuarioGuardado != null) {
            System.out.println("todo anda bien");
        } else {
            // Ocurrió un error al guardar el usuario, muestra un mensaje de error o realiza alguna acción apropiada.
        }
        FxWeaver fxWeaver = Main.getContext().getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(LogInController.class);
        signin_button.getScene().setRoot(root);
    }
}
