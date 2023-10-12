package com.example.entities;

import jakarta.persistence.*;

@Entity
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long IdPlane;

    @Column
    private Long IdAirline;

    @Column
    private String Current_Airport;

    @Column
    private Long IdTypePlane;

	public Long getIdPlane() {
		return this.IdPlane;
	}

	public void setIdPlane(Long IdPlane) {
		this.IdPlane = IdPlane;
	}

	public Long getIdAirline() {
		return this.IdAirline;
	}

	public void setIdAirline(Long IdAirline) {
		this.IdAirline = IdAirline;
	}

	public String getCurrent_Airport() {
		return this.Current_Airport;
	}

	public void setCurrent_Airport(String Current_Airport) {
		this.Current_Airport = Current_Airport;
	}

	public Long getIdTypePlane() {
		return this.IdTypePlane;
	}

	public void setIdTypePlane(Long IdTypePlane) {
		this.IdTypePlane = IdTypePlane;
	}



}