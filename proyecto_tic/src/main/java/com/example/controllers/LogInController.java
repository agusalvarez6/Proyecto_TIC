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
import org.springframework.stereotype.Component;

import com.example.entities.Account;

import java.io.IOException;
@Component
public class LogInController {
   @FXML
   private PasswordField contrasena_field;
   @FXML
   private Button login_button;
   @FXML
   private Button signin_view_button;
   @FXML
   private TextField usuario_field;

   public LogInController() {
   }

   @FXML
   void login_try(ActionEvent event) {
      int rol = 0;
      if (this.usuario_field.getText().equals("usuario")) {
         rol = 1;
      } else if (this.usuario_field.getText().equals("aerolinea")) {
         rol = 2;
      } else if (this.usuario_field.getText().equals("aeropuerto")) {
         rol = 3;
      } else if (this.usuario_field.getText().equals("admin")) {
         rol = 4;
      }

      try {
         FXMLLoader loader = new FXMLLoader();
         Parent root = null;
         Stage stage = new Stage();
         switch (rol) {
            case 1:
               loader.setLocation(this.getClass().getResource("/com/example/controllers/landing_page.fxml"));
               root = (Parent)loader.load();
               stage.setTitle("Usuario");
               break;
            case 2:
               loader.setLocation(this.getClass().getResource("/com/example/controllers/landing_aerolinea.fxml"));
               root = (Parent)loader.load();
               stage.setTitle("Aerol\u00ednea");
               break;
            case 3:
               loader.setLocation(this.getClass().getResource("/com/example/controllers/aeropuerto.fxml"));
               root = (Parent)loader.load();
               stage.setTitle("Aeropuerto");
               break;
            case 4:
               loader.setLocation(this.getClass().getResource("/com/example/controllers/admin.fxml"));
               root = (Parent)loader.load();
               stage.setTitle("Administrador");
         }

         if (root != null) {
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
         }
      } catch (IOException var7) {
         var7.printStackTrace();
      }

   }

   @FXML
   void signin_view(ActionEvent event) {
      try {
         FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/signIn.fxml"));
         Parent signInRoot = (Parent)loader.load();
         Stage signInStage = new Stage();
         signInStage.setTitle("Sign In");
         Scene signInScene = new Scene(signInRoot);
         signInStage.setScene(signInScene);
         signInStage.show();
      } catch (IOException var6) {
         var6.printStackTrace();
      }

   }
}
