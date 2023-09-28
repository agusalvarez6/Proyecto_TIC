package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.example.App;
@SpringBootApplication
public class Main {
    /*
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/login.fxml"));
        primaryStage.setTitle("Guardar Valores en Array");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        DataBase.start();
    }
    */
    private static ConfigurableApplicationContext context;


    public static void main(String[] args) {
        Main.context = SpringApplication.run(Main.class);
        Application.launch(App.class, args);
    }
    public static ConfigurableApplicationContext getContext() {
        return context;
    }
}
