package com.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
import com.example.entities.Airport;
import com.example.entities.AirportEmployee;
import com.example.entities.Shop;
import com.example.services.AirlineService;
import com.example.services.AirportService;

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
    private TextField iataEmpleado;

    @FXML
    private Tab verusuarios_tab;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private AirportService airportService;

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

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Aerolínea Guardada");
    alert.setHeaderText(null);
    alert.setContentText("La aerolínea se ha guardado exitosamente.");

    alert.showAndWait();

    usuarioaerolinea_field.setText("");
    contrasenaaerolinea_field.setText("");
    nameaerolinea_field.setText("");

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
        
      /*   FxWeaver fxWeaver = Main.getContext().getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(LogInController.class);
        ingresaraerolinea_button.getScene().setRoot(root); */
    }
    @FXML
    void saveAirport(ActionEvent event){
        String username = usuarioaerop_field.getText();
        String password = contrasenaaeropuerto_field.getText();
        String name = nameaeropuerto_field.getText();
        String city = ciudadaeropuerto_field.getText();
        String country = paisaeropuerto_field.getText();
        String iata = codigoiata_field.getText();
        // Verifica que las contraseñas coincidan (puedes agregar más validaciones si es necesario)
        if (!password.equals(contrasenaaeropuerto_field.getText())) {
            // Muestra un mensaje de error o realiza alguna acción apropiada.
            return;
        }
        if (!airportService.VerificarDestino(iata)) {
                
        Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Aeropuerto Guardado");
    alert.setHeaderText(null);
    alert.setContentText("El aeropuerto se ha guardado exitosamente.");
    // Mostrar el cuadro de diálogo
    alert.showAndWait();
    
    usuarioaerop_field.setText("");
    contrasenaaeropuerto_field.setText("");
    nameaeropuerto_field.setText("");
    ciudadaeropuerto_field.setText("");
    paisaeropuerto_field.setText("");
    codigoiata_field.setText("");

            // Crea un nuevo objeto de usuario
            Account nuevoUsuario = new Account();
            nuevoUsuario.setUsername(username);
            nuevoUsuario.setPassword(password);
            nuevoUsuario.setRole("aeropuerto");
            // Llama al servicio para guardar el usuario
            Account usuarioGuardado = accountService.saveAccount(nuevoUsuario);

            if (usuarioGuardado != null) {
                System.out.println("usuario guardado");
                Airport newAirport = new Airport();
                newAirport.setName(name);
                newAirport.setCity(city);
                newAirport.setCountry(country);
                newAirport.setIATA(iata);
                newAirport.setIdAccount(usuarioGuardado.getIdAccount());
                Airport airportGuardado = airportService.saveAirport(newAirport);
                if (airportGuardado != null) {
                    System.out.println("aeropuerto guardado");
                } else {
                    // Ocurrió un error al guardar el usuario, muestra un mensaje de error o realiza alguna acción apropiada.
                }
            } else {
                // Ocurrió un error al guardar el usuario, muestra un mensaje de error o realiza alguna acción apropiada.
            }
        }
    }

    @FXML
    void saveEmployee(ActionEvent event){
        String username = usuarioempleado_field.getText();
        String password = contrasenaempleado_field.getText();
        String name = nameempleado_field.getText();
        String role = rolempleado_field.getText();
        String salary = sueldoempleado_field.getText();
        String iata = iataEmpleado.getText();
        // Verifica que las contraseñas coincidan (puedes agregar más validaciones si es necesario)
        if (username.equals("") || password.equals("") || name.equals("") || role.equals("") || salary.equals("") || iata.equals("") ) {
            // Muestra un mensaje de error o realiza alguna acción apropiada.
            return;
        }

        // Crea un nuevo objeto de usuario
        if(airportService.VerificarDestino(iata)){
            Account nuevoUsuario = new Account();
            nuevoUsuario.setUsername(username);
            nuevoUsuario.setPassword(password);
            nuevoUsuario.setRole("empleado");
            // Llama al servicio para guardar el usuario
            Account usuarioGuardado = accountService.saveAccount(nuevoUsuario);
            if (usuarioGuardado != null) {
                AirportEmployee newEmployee = new AirportEmployee();
                newEmployee.setName(name);
                newEmployee.setRol(role);
                newEmployee.setSalary(salary);
                newEmployee.setIdAccount(usuarioGuardado.getIdAccount());
                newEmployee.setIataAirport(iata);

                accountService.registerAirportEmployee(newEmployee);
                System.out.println("empleado guardado");
            } else {
                System.out.println("empleado no guardado");
                // Ocurrió un error al guardar el usuario, muestra un mensaje de error o realiza alguna acción apropiada.
            }
        }
    }

    @FXML
    void saveLocal(ActionEvent event){
        String username = usuariolocal_field.getText();
        String password = contrasenalocal_field.getText();
        String name = namelocal_field.getText();
        String type = tipolocal_field.getText();
        String iata = iatalocal_field.getText();
        // Verifica que las contraseñas coincidan (puedes agregar más validaciones si es necesario)
         if (username.equals("") || password.equals("") || name.equals("") || type.equals("") || iata.equals("")) {
            // Muestra un mensaje de error o realiza alguna acción apropiada.
            return;
        }
        if(airportService.VerificarDestino(iata)){
            // Crea un nuevo objeto de usuario
            Account nuevoUsuario = new Account();
            nuevoUsuario.setUsername(username);
            nuevoUsuario.setPassword(password);
            nuevoUsuario.setRole("local");
            // Llama al servicio para guardar el usuario
            Account usuarioGuardado = accountService.saveAccount(nuevoUsuario);

            if (usuarioGuardado != null && airportService.VerificarDestino(iata)) {
                Shop newShop = new Shop();
                newShop.setShopName(name);
                newShop.setType(type);
                newShop.setIataAirport(iata);
                newShop.setIdAccount(usuarioGuardado.getIdAccount());

                accountService.registerShop(newShop);
                System.out.println("local guardado");
            } else {
                System.out.println("local no guardado");
                // Ocurrió un error al guardar el usuario, muestra un mensaje de error o realiza alguna acción apropiada.
            }
        }
    }

    void initialize(String username) {
        System.out.println("username: " + username);
    }
}
