package com.example.entities;

import jakarta.persistence.*;

@Entity
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long idPlane;

    @Column
    private Long idAirline;

	@Column
    private String numero;

	@Column
    private String capacity;

	public Long getIdPlane() {
		return this.idPlane;
	}

	public void setIdPlane(Long IdPlane) {
		this.idPlane = IdPlane;
	}

	public Long getIdAirline() {
		return this.idAirline;
	}

	public void setIdAirline(Long IdAirline) {
		this.idAirline = IdAirline;
	}

	public String getCapacity() {
		return this.capacity;
	}

	public void setCapacity(String Capacity) {
		this.capacity = Capacity;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String Numero) {
		this.numero = Numero;
	}

}