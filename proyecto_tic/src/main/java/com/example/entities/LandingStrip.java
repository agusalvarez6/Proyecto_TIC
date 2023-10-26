package com.example.entities;

import jakarta.persistence.*;

@Entity
public class LandingStrip {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long IdLandingStrip;

    @Column
    private Long IdAirport;

    @Column
    private String Status;

	public Long getIdLandingStrip() {
		return this.IdLandingStrip;
	}

	public void setIdLandingStrip(Long IdLandingStrip) {
		this.IdLandingStrip = IdLandingStrip;
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