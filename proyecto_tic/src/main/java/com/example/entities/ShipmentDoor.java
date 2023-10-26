package com.example.entities;

import jakarta.persistence.*;

@Entity
public class ShipmentDoor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long IdDoor;

    @Column
    private Long IdAirport;

    @Column
    private String Status;

	public Long getIdDoor() {
		return this.IdDoor;
	}

	public void setIdDoor(Long IdDoor) {
		this.IdDoor = IdDoor;
	}

	public Long getIdAirport() {
		return this.IdAirport;
	}

	public void setIdAirport(Long IdAirport) {
		this.IdAirport = IdAirport;
	}

	public String getStatus() {
		return this.Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}

}