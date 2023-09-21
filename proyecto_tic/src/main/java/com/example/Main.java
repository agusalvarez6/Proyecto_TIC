package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/login.fxml"));
        primaryStage.setTitle("Guardar Valores en Array");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        DataBase.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
