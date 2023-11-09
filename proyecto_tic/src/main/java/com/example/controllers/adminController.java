package com.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

import com.example.Main;
import com.example.entities.Account;
import com.example.services.AccountService;
import com.example.entities.Airline;
import com.example.services.AirlineService;

@Component
@FxmlView("/com/example/controllers/admin.fxml")
public class adminController {

    @FXML
    private TextField usuarioaerop_field;

    @FXML
    private Button atras_button;
    
    @FXML
    private Button buscarusuarios_button;

    @FXML
    private TextField buscarusuarios_field;

    @FXML
    private TextField ciudadaeropuerto_field;

    @FXML
    private TextField codigoiata_field;

    @FXML
    private TextField contrasenaaerolinea_field;

    @FXML
    private TextField contrasenaaeropuerto_field;

    @FXML
    private TextField contrasenaempleado_field;

    @FXML
    private TextField contrasenalocal_field;

    @FXML
    private Tab crearaeroli_tab;

    @FXML
    private Tab crearaerop_tab;

    @FXML
    private Tab crearempleado_tab;

    @FXML
    private Tab crearlocal_tab;

    @FXML
    private TextField iatalocal_field;

    @FXML
    private Button ingresaraerolinea_button;

    @FXML
    private Button ingresaraeropuerto_button;

    @FXML
    private Button ingresarempleado_field;

    @FXML
    private Button ingresarlocal_field;

    @FXML
    private TextArea mostrarusuarios_area;

    @FXML
    private TextField nameaerolinea_field;

    @FXML
    private TextField nameaeropuerto_field;

    @FXML
    private TextField nameempleado_field;

    @FXML
    private TextField namelocal_field;

    @FXML
    private TextField paisaeropuerto_field;

    @FXML
    private TextField rolempleado_field;

    @FXML
    private TextField sueldoempleado_field;

    @FXML
    private TextField tipolocal_field;

    @FXML
    private TextField usuarioaerolinea_field;

    @FXML
    private TextField usuarioempleado_field;

    @FXML
    private TextField usuariolocal_field;

    @FXML
    private Tab verusuarios_tab;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AirlineService airlineService;

    @FXML
    void salir(ActionEvent event) {
        FxWeaver fxWeaver = Main.getContext().getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(InicioController.class);
        atras_button.getScene().setRoot(root);
    }

    @FXML
    void saveAirline(ActionEvent event){
        String username = usuarioaerolinea_field.getText();
        String password = contrasenaaerolinea_field.getText();
        String name = nameaerolinea_field.getText();
        // Verifica que las contraseñas coincidan (puedes agregar más validaciones si es necesario)
        if (!password.equals(contrasenaaerolinea_field.getText())) {
            // Muestra un mensaje de error o realiza alguna acción apropiada.
            return;
        }

        // Crea un nuevo objeto de usuario
        Account nuevoUsuario = new Account();
        nuevoUsuario.setUsername(username);
        nuevoUsuario.setPassword(password);
        nuevoUsuario.setRole("aerolinea");
        // Llama al servicio para guardar el usuario
        Account usuarioGuardado = accountService.saveAccount(nuevoUsuario);

        if (usuarioGuardado != null) {
            System.out.println("usuario guardado");
        } else {
            
            // Ocurrió un error al guardar el usuario, muestra un mensaje de error o realiza alguna acción apropiada.
        }

        Airline newAirline = new Airline();
        newAirline.setName(name);
        newAirline.setIdAccount(usuarioGuardado.getIdAccount());
        Airline airlineGuardada = airlineService.saveAirline(newAirline);
        if (airlineGuardada != null) {
            System.out.println("aerolinea guardada");
        } else {
            // Ocurrió un error al guardar el usuario, muestra un mensaje de error o realiza alguna acción apropiada.
        }
        
        FxWeaver fxWeaver = Main.getContext().getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(LogInController.class);
        ingresaraerolinea_button.getScene().setRoot(root);
    }

    void initialize(String username) {
        System.out.println("username: " + username);
    }
}
