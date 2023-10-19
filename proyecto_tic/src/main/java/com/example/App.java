package com.example;

import com.example.controllers.InicioController;
import com.example.controllers.LogInController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;


public class App extends Application {

    @Override
    public void init() throws Exception {

    }
    private Parent root;
    private Scene scene;
    @Override
    public void start(Stage primaryStage) throws Exception {
        FxWeaver fxWeaver = Main.getContext().getBean(FxWeaver.class);
        root = fxWeaver.loadView(InicioController.class);
        scene = new Scene(root, 600, 400);


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        Main.getContext().close();
    }
}