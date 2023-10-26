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
    private String StateOrigin;

    @Column
    private String StateDestination;

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

    public String getStateOrigin() {
		return this.StateOrigin;
	}

	public void setStateOrigin(String StateOrigin) {
		this.StateOrigin = StateOrigin;
	}

	public String getStateDestination() {
		return this.StateDestination;
	}

	public void setStateDestination(String StateDestination) {
		this.StateDestination = StateDestination;
	}
}