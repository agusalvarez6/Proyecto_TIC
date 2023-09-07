package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class SampleController {
    @FXML
    private TextField nombrefield;
    @FXML
    private TextField apellidofield;

    private ObservableList<String> valores = FXCollections.observableArrayList();

    @FXML
    protected void guardarValor() throws Exception {
        String nombre = nombrefield.getText();
        String apellido = apellidofield.getText();
        DataBase.save(nombre,apellido);
        nombrefield.clear();
        apellidofield.clear();
        DataBase.print();
    }
}
