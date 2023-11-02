package com.example.entities;


import jakarta.persistence.*;

@Entity
public class PendingFlights {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long idPendingFlights;

    @Column
    private Long idFlights;

    @Column
    private Long origin;

    @Column
    private Long destination;

    @Column
    private int stateOrigin;

    @Column
    private int stateDestination;

    public Long getIdPendingFlights() {
		return this.idPendingFlights;
	}

	public void setIdPendingFlights(Long IdPendingFlights) {
		this.idPendingFlights = IdPendingFlights;
	}
    public Long getIdFlights() {
		return this.idFlights;
	}

	public void setIdFlights(Long IdFlights) {
		this.idFlights = IdFlights;
	}
    public Long getOrigin() {
		return this.origin;
	}

	public void setOrigin(Long Origin) {
		this.origin = Origin;
	}

	public Long getDestination() {
		return this.destination;
	}

	public void setDestination(Long Destination) {
		this.destination = Destination;
	}

    public int getStateOrigin() {
		return this.stateOrigin;
	}

	public void setStateOrigin(int StateOrigin) {
		this.stateOrigin = StateOrigin;
	}

	public int getStateDestination() {
		return this.stateDestination;
	}

	public void setStateDestination(int i) {
		this.stateDestination = i;
	}
}