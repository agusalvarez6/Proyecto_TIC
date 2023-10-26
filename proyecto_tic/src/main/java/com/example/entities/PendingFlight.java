package com.example.entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class PendingFlights {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long IdPendingFlights;

    @Column
    private Long IdFlights;

    @Column
    private String Origin;

    @Column
    private String Destination;

    @Column
    private int StateOrigin;

    @Column
    private int StateDestination;

    public Long getIdPendingFlights() {
		return this.IdPendingFlights;
	}

	public void setIdPendingFlights(Long IdPendingFlights) {
		this.IdPendingFlights = IdPendingFlights;
	}
    public Long getIdFlights() {
		return this.IdFlights;
	}

	public void setIdFlights(Long IdFlights) {
		this.IdFlights = IdFlights;
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

    public int getStateOrigin() {
		return this.StateOrigin;
	}

	public void setStateOrigin(int StateOrigin) {
		this.StateOrigin = StateOrigin;
	}

	public int getStateDestination() {
		return this.StateDestination;
	}

	public void setStateDestination(int StateDestination) {
		this.StateDestination = StateDestination;
	}
}