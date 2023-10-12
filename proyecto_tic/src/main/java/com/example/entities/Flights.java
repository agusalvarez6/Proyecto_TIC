package com.example.entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Flights {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long IdFlights;

    @Column
    private Long IdAirline;

    @Column
    private String Origin;

    @Column
    private String Destination;

    @Column
    private LocalDate Departure_time;

    @Column
    private LocalDate Arrival_time;

    @Column
    private Long Departure_door;

    @Column
    private Long Arrival_door;

    @Column
    private String Code;

    @Column
    private Long IdPlane;

	public String getCode() {
		return this.Code;
	}

	public void setCode(String Code) {
		this.Code = Code;
	}

	public Long getIdFlights() {
		return this.IdFlights;
	}

	public void setIdFlights(Long IdFlights) {
		this.IdFlights = IdFlights;
	}

	public Long getIdAirline() {
		return this.IdAirline;
	}

	public void setIdAirline(Long IdAirline) {
		this.IdAirline = IdAirline;
	}

	public String getOrigin() {
		return this.Origin;
	}

	public void setOrigin(String Origin) {
		this.Origin = Origin;
	}

	public String getDestination() {
		return this.Destination;
	}

	public void setDestination(String Destination) {
		this.Destination = Destination;
	}

	public LocalDate getDeparture_time() {
		return this.Departure_time;
	}

	public void setDeparture_time(LocalDate Departure_time) {
		this.Departure_time = Departure_time;
	}

	public LocalDate getArrival_time() {
		return this.Arrival_time;
	}

	public void setArrival_time(LocalDate Arrival_time) {
		this.Arrival_time = Arrival_time;
	}

	public Long getDeparture_door() {
		return this.Departure_door;
	}

	public void setDeparture_door(Long Departure_door) {
		this.Departure_door = Departure_door;
	}

	public Long getArrival_door() {
		return this.Arrival_door;
	}

	public void setArrival_door(Long Arrival_door) {
		this.Arrival_door = Arrival_door;
	}

	public Long getIdPlane() {
		return this.IdPlane;
	}

	public void setIdPlane(Long IdPlane) {
		this.IdPlane = IdPlane;
	}


}
