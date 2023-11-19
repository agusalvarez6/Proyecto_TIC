package com.example.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import net.rgielen.fxweaver.core.FxmlView;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.rgielen.fxweaver.core.FxWeaver;

import com.example.Main;
import com.example.entities.Airline;
import com.example.entities.Flights;
import com.example.entities.Plane;
import com.example.services.AccountService;
import com.example.services.AirlineService;
import com.example.services.AirportService;
import com.example.services.FlightsService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Component
@FxmlView("/com/example/controllers/landing_aerolinea.fxml")
public class LandingAerolineaController {

   
    @FXML
    private TextField aeropdestino_field;

    @FXML
    private TextField aeroporigen_field;

    @FXML
    private Button agendarvuelo_button;

    @FXML
    private Tab agendarvuelo_tab;

    @FXML
    private Button agregaravion_button;

    @FXML
    private Tab agregaravion_tab;

    @FXML
    private Button atras_button;

    @FXML
    private TextField capacidadavion_field;

    @FXML
    private TextField aeropincial_field;

    @FXML
    private TextField salida_field;

    @FXML
    private TextField llegada_field;

    @FXML
    private TableColumn<Flights, String> destino_col;

    @FXML
    private TextField horallegada_field;

    @FXML
    private TextField horasalida_field;

    @FXML
    private TableColumn<Flights, String> llegada_col;

    @FXML
    private TextField nroavion_field;

    @FXML
    private TextField numeroavion_field;

    @FXML
    private TableColumn<Flights, String> numerovuelo_col;

    @FXML
    private TextField fechainicialavion_field;

    @FXML
    private TextField numerovuelo_field;

    @FXML
    private TableColumn<Flights, String> origen_col;

    @FXML
    private TableColumn<Flights, String> salida_col;

    @FXML
    private Tab vuelosagendados_tab;

    @FXML
    private TableView<Flights> vuelosagendados_table;

    @FXML
    private TextField tiempodesembarque_field;

    @FXML
    private TextField tiempoembarque_field;

    @FXML
    private TextField tiempopista_field;

    @FXML
    private TextField modeloavion_field;

    @FXML
    private Button Eliminar_Vuelo;

    @FXML
    private Button Agregar_Pasajero;

    @FXML
    private TableColumn<Flights, String> estadovuelo_col;

    @FXML
    private TextField Pasaporte;

    @Autowired
    private FlightsService flightsService;

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AirportService airportService;

    @FXML
    void salir(ActionEvent event) {
        FxWeaver fxWeaver = Main.getContext().getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(InicioController.class);
        atras_button.getScene().setRoot(root);
    }

    @FXML
    void saveFlight(ActionEvent event){
        Flights vuelo = new Flights();

        vuelo.setCode(numerovuelo_field.getText());
        vuelo.setDestination(aeropdestino_field.getText());
        vuelo.setOrigin(aeroporigen_field.getText());
        vuelo.setArrival_time(llegada_field.getText());
        vuelo.setDeparture_time(salida_field.getText());
        vuelo.setStateDestination(0);
        vuelo.setStateOrigin(0);
        vuelo.setIdAirline(aerolinea.getIdAirline());
        //vuelo.setIdPlane(nroavion_field.getText());
        Plane avion = flightsService.ComprobarAvion(nroavion_field.getText(), aerolinea.getIdAirline());
        if (avion==null){
            System.out.println("Avion no encontrado");
            return;
        }else{
            vuelo.setIdPlane(avion.getIdPlane());
        }
        if (flightsService.existFlight(vuelo.getCode())==true){
            System.out.println("Vuelo ya existente");
            return;
        }
        if (airportService.existAirport(vuelo.getOrigin())==false){
            System.out.println("Aeropuerto de origen no encontrado");
            return;
        }
        if (airportService.existAirport(vuelo.getDestination())==false){
            System.out.println("Aeropuerto de destino no encontrado");
            return;
        }
        LocalDateTime departureTime = LocalDateTime.parse(vuelo.getDeparture_time(), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        LocalDateTime arrivalTime = LocalDateTime.parse(vuelo.getArrival_time(), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        if (departureTime.isAfter(arrivalTime)){
            System.out.println("Horario no valido");
            return;
        }
        flightsService.saveFlights(vuelo);
        System.out.println("Todo anda bien");

         // Mostrar una alerta indicando que el vuelo se ha agendado
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Vuelo Agendado");
    alert.setHeaderText(null);
    alert.setContentText("El vuelo se ha agendado exitosamente.");

    alert.showAndWait();

    // Limpiar los campos de texto después de agendar el vuelo
    numerovuelo_field.setText("");
    aeropdestino_field.setText("");
    aeroporigen_field.setText("");
    llegada_field.setText("");
    salida_field.setText("");
    nroavion_field.setText("");
    vuelos = flightsService.verVuelosDeAerolinea(aerolinea.getIdAirline());

      ObservableList<Flights> vuelosObs = FXCollections.observableArrayList(vuelos);
      vuelosagendados_table.setItems(vuelosObs);

      Platform.runLater(() -> vuelosagendados_table.refresh());  
    } 

    
    List<Flights> vuelos;
    Airline aerolinea;
    Long setUsuario(Long usuario){
        aerolinea = airlineService.getAirlineId(usuario);
        vuelos = flightsService.verVuelosDeAerolinea(aerolinea.getIdAirline());
        return usuario;
    }
    @FXML
    void initialize() {
        if(vuelos!=null){
            ObservableList<Flights> vuelosObs = FXCollections.observableArrayList(vuelos);

            vuelosagendados_table.setItems(vuelosObs);


            numerovuelo_col.setCellValueFactory(new PropertyValueFactory<Flights,String>("code"));
            origen_col.setCellValueFactory(new PropertyValueFactory<Flights,String>("origin"));
            destino_col.setCellValueFactory(new PropertyValueFactory<Flights,String>("destination"));
            salida_col.setCellValueFactory(new PropertyValueFactory<Flights,String>("departure_time"));
            llegada_col.setCellValueFactory(new PropertyValueFactory<Flights,String>("arrival_time"));
            estadovuelo_col.setCellValueFactory(new PropertyValueFactory<Flights,String>("state"));
            vuelosagendados_table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        }
    }

    @FXML
    void savePlane(ActionEvent event){
        Plane avion = new Plane();
        avion.setCapacity(capacidadavion_field.getText());
        avion.setIdAirline(aerolinea.getIdAirline());
        avion.setNumero(numeroavion_field.getText());
        if (flightsService.existPlane(avion.getNumero())==false){
            flightsService.savePlane(avion);
            System.out.println("Avion guardado");
        }
        else{
            System.out.println("Numero ya existente");
        }        
        printAviones();
    
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Avión Guardado");
    alert.setHeaderText(null);
    alert.setContentText("El avión se ha guardado exitosamente.");

    alert.showAndWait();

    // Limpiar los campos de texto después de agendar el vuelo
    capacidadavion_field.setText("");
    numeroavion_field.setText("");
    fechainicialavion_field.setText("");
    aeropincial_field.setText("");
    modeloavion_field.setText("");
    
    }
    
    private void printAviones(){
        System.out.println("Todos los aviones registrados: ");
        for (Plane avion : flightsService.verTodosLosAviones(aerolinea.getIdAirline())) {
            System.out.println(avion.getIdPlane()+" "+avion.getNumero()+" "+avion.getCapacity()+" "+avion.getIdAirline());
        }
    }

    @FXML
    void deleteFlight(ActionEvent event){
        Flights vuelo = vuelosagendados_table.getSelectionModel().getSelectedItem();
        if (vuelo!=null){
            flightsService.RechazarVuelo(vuelo);
            System.out.println("Vuelo eliminado");
            vuelos = flightsService.verVuelosDeAerolinea(aerolinea.getIdAirline());
            ObservableList<Flights> vuelosObs = FXCollections.observableArrayList(vuelos);
            vuelosagendados_table.setItems(vuelosObs);
            Platform.runLater(() -> vuelosagendados_table.refresh());  
        }else{
            System.out.println("Por favor, selecciona un vuelo para rechazar.");

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Vuelo no seleccionado");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecciona un vuelo para rechazar.");
    
            alert.showAndWait();
        }
    }

    @FXML
    void addPassenger(ActionEvent event){
        Flights vuelo = vuelosagendados_table.getSelectionModel().getSelectedItem();
        if (vuelo!=null){
            if(vuelo.getState().equals("Aprobado")){
                String pasaporte = Pasaporte.getText();
                if (accountService.existPasaport(pasaporte)){
                    if(flightsService.buyTicket(vuelo,pasaporte, aerolinea.getIdAirline())){
                        System.out.println("Pasajero agregado");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Pasajero agregado");
                        alert.setHeaderText(null);
                        alert.setContentText("El pasajero se ha agregado exitosamente.");
                        alert.showAndWait();
                    }else{
                        System.out.println("Pasajero no agregado");
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Pasajero no agregado");
                        alert.setHeaderText(null);
                        alert.setContentText("La capacidad del vuelo esta completa.");
                        alert.showAndWait();
                    }
                }else{
                    System.out.println("Pasajero no existente");

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Pasajero no encontrado");
                    alert.setHeaderText(null);
                    alert.setContentText("Por favor, selecciona ingrese un pasaporte vigente.");
            
                    alert.showAndWait();
                }
            }
        }else{
                System.out.println("Por favor, selecciona un vuelo para agregar pasajeros.");

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Vuelo no seleccionado");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, selecciona un vuelo para agregar pasajeros.");
        
                alert.showAndWait();
        }
    }
}
