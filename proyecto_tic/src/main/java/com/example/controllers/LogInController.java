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

import org.springframework.stereotype.Component;

import com.example.Main;
import com.example.entities.Account;

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

         FxWeaver fxWeaver = InicioController.getContext().getBean(FxWeaver.class);
         switch (rol) {
            case 1:
               Parent root = fxWeaver.loadView(landing_controller.class);
               login_button.getScene().setRoot(root);
               break;
            case 2:
               fxWeaver = Main.getContext().getBean(FxWeaver.class);
               root = fxWeaver.loadView(LandingAerolineaController.class);
               break;
            case 3:
               fxWeaver = Main.getContext().getBean(FxWeaver.class);
               root = fxWeaver.loadView(adminController.class);
               break;
            case 4:
               fxWeaver = Main.getContext().getBean(FxWeaver.class);
                root = fxWeaver.loadView(adminController.class);
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
