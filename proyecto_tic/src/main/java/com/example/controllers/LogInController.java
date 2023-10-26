package com.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Main;
import com.example.entities.Account;
import com.example.services.AccountService;

import java.io.IOException;
@Component
@FxmlView("/com/example/controllers/login.fxml")
public class LogInController {
   @FXML
   private PasswordField contrasena_field;
   @FXML
   private Button login_button;
   @FXML
   private Button signin_view_button;
   @FXML
   private TextField usuario_field;
   @Autowired
    private AccountService accountService;
   public LogInController() {
   }

   @FXML
   void login_try(ActionEvent event) {
      int rol = 0;
      String username = usuario_field.getText();
      String password = contrasena_field.getText();
      Account usuarioGuardado = accountService.userAuthentication(username, password);
      if (usuarioGuardado != null){
         System.out.println("todo anda bien");
         
         if (usuarioGuardado.getRole().equals("usuario")) {
            rol = 1;
         } else if (usuarioGuardado.getRole().equals("aerolinea")) {
            rol = 2;
         } else if (usuarioGuardado.getRole().equals("aeropuerto")) {
            rol = 3;
         } else if (usuarioGuardado.getRole().equals("admin")) {
            rol = 4;
         }
      }
         else{
         System.out.println("todo anda mal");
      }
      
      rol = 1;
         
         switch (rol) {
            case 1:
               FxWeaver fxWeaver = Main.getContext().getBean(FxWeaver.class);
               Parent root = fxWeaver.loadView(landing_controller.class);
               login_button.getScene().setRoot(root);
               break;
            case 2:
               fxWeaver = Main.getContext().getBean(FxWeaver.class);
               root = fxWeaver.loadView(LandingAerolineaController.class);
               login_button.getScene().setRoot(root);
               break;
            case 3:
               fxWeaver = Main.getContext().getBean(FxWeaver.class);
               root = fxWeaver.loadView(landing_aeropuertoController.class);
               login_button.getScene().setRoot(root);
               break;
            case 4:
               fxWeaver = Main.getContext().getBean(FxWeaver.class);
                root = fxWeaver.loadView(adminController.class);
                login_button.getScene().setRoot(root);
         }
      
      }

   

   @FXML
   void signin_view(ActionEvent event) {
      FxWeaver fxWeaver = Main.getContext().getBean(FxWeaver.class);
      Parent root = fxWeaver.loadView(SignInController.class);
      login_button.getScene().setRoot(root);
   }
}
