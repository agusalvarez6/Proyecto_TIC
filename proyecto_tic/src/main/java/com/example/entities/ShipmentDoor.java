package com.example.entities;

import jakarta.persistence.*;

@Entity
public class ShipmentDoor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long idDoor;

	@Column
    private String numberDoor;

    @Column
    private String idAirport;

	public ShipmentDoor(String numberDoor, String IdAirport) {
		this.numberDoor = numberDoor;
		this.idAirport = IdAirport;
	}

	public ShipmentDoor() {
	}
	public Long getIdDoor() {
		return this.idDoor;
	}

	public void setIdDoor(Long IdDoor) {
		this.idDoor = IdDoor;
	}

	public String getNumberDoor() {
		return this.numberDoor;
	}

	public void setNumberDoor(String numberDoor) {
		this.numberDoor = numberDoor;
	}
	public String getIdAirport() {
		return this.idAirport;
	}

	public void setIdAirport(String IdAirport) {
		this.idAirport = IdAirport;
	}

}