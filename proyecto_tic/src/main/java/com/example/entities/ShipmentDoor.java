package com.example.entities;

import jakarta.persistence.*;

@Entity
public class ShipmentDoor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long IdDoor;

	@Column
    private String numberDoor;

    @Column
    private Long IdAirport;

	public ShipmentDoor(String numberDoor, Long IdAirport) {
		this.numberDoor = numberDoor;
		this.IdAirport = IdAirport;
	}

	public Long getIdDoor() {
		return this.IdDoor;
	}

	public void setIdDoor(Long IdDoor) {
		this.IdDoor = IdDoor;
	}

	public String getNumberDoor() {
		return this.numberDoor;
	}

	public void setNumberDoor(String numberDoor) {
		this.numberDoor = numberDoor;
	}
	public Long getIdAirport() {
		return this.IdAirport;
	}

	public void setIdAirport(Long IdAirport) {
		this.IdAirport = IdAirport;
	}

}