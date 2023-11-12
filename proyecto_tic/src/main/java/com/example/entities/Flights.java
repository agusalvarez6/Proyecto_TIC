package com.example.entities;


import jakarta.persistence.*;

@Entity
public class Flights {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long idFlights;

    @Column
    private Long idAirline;

    @Column
    private String origin;

    @Column
    private String destination;

    @Column
    private String departure_time;

    @Column
    private String arrival_time;

    @Column
    private Long departure_door;

    @Column
    private Long arrival_door;

    @Column
    private int state;

    @Column
    private String code;

    @Column
    private Long idPlane;

	public Flights() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String Code) {
		this.code = Code;
	}

	public Long getIdFlights() {
		return this.idFlights;
	}

	public void setIdFlights(Long IdFlights) {
		this.idFlights = IdFlights;
	}

	public Long getIdAirline() {
		return this.idAirline;
	}

	public void setIdAirline(Long IdAirline) {
		this.idAirline = IdAirline;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String Origin) {
		this.origin = Origin;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String Destination) {
		this.destination = Destination;
	}

	public String getDeparture_time() {
		return this.departure_time;
	}

	public void setDeparture_time(String Departure_time) {
		this.departure_time = Departure_time;
	}

	public String getArrival_time() {
		return this.arrival_time;
	}

	public void setArrival_time(String Arrival_time) {
		this.arrival_time = Arrival_time;
	}

	public Long getDeparture_door() {
		return this.departure_door;
	}

	public void setDeparture_door(Long Departure_door) {
		this.departure_door = Departure_door;
	}

	public Long getArrival_door() {
		return this.arrival_door;
	}

	public void setArrival_door(Long Arrival_door) {
		this.arrival_door = Arrival_door;
	}

	public Long getIdPlane() {
		return this.idPlane;
	}

	public void setIdPlane(Long IdPlane) {
		this.idPlane = IdPlane;
	}
	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
