package com.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entities.Account;
import com.example.entities.Flights;

import java.io.IOException;
import java.util.List;

import net.rgielen.fxweaver.core.FxWeaver;

import com.example.Main;
import com.example.entities.Account;
import com.example.services.AccountService;
import com.example.services.AirportService;
import com.example.services.FlightsService;

@Component
@FxmlView("/com/example/controllers/landing_page.fxml")
public class landing_controller {

    @FXML
    private TableColumn<Flights,String> Destino_col;

    @FXML
    private TableColumn<Flights,String> Fecha_Llegada_col;

    @FXML
    private TableColumn<Flights,String> Fecha_salida_col;

    @FXML
    private TableColumn<Flights,String> Origen_col;

    @FXML
    private TableView<Flights> Reservas_Table;

    @FXML
    private Button salir_button;

    @Autowired
    private FlightsService flightsService;

    @FXML
    void Salir(ActionEvent event) {
        FxWeaver fxWeaver = Main.getContext().getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(InicioController.class);
        salir_button.getScene().setRoot(root);
    }

    List<Flights> vuelos;
    void setUsuario(Account usuario){
        vuelos = flightsService.getFlightsByPassport(usuario.getPassport());
    }

    @FXML
    void initialize() {
        if (vuelos != null) {
            ObservableList<Flights> vuelosObs = FXCollections.observableArrayList(vuelos);
    
            Reservas_Table.setItems(vuelosObs);
    
            Origen_col.setCellValueFactory(new PropertyValueFactory<Flights, String>("origin"));
            Destino_col.setCellValueFactory(new PropertyValueFactory<Flights, String>("destination"));
            Fecha_salida_col.setCellValueFactory(new PropertyValueFactory<Flights, String>("departure_time"));
            Fecha_Llegada_col.setCellValueFactory(new PropertyValueFactory<Flights, String>("arrival_time"));
        }
    }

}
