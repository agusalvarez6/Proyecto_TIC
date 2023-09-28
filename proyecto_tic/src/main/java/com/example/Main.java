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
    private static ConfigurableApplicationContext context;


    public static void main(String[] args) {
        Main.context = SpringApplication.run(Main.class);
        Application.launch(App.class, args);
    }
    public static ConfigurableApplicationContext getContext() {
        return context;
    }
}
