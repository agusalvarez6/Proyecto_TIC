package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/inicio.fxml"));
            primaryStage.setTitle("Guardar Valores en Array");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();
            DataBase.start();
        } catch (Exception e) {
            // Imprimir detalles de la excepción en la consola
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
