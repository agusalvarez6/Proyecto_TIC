package com.example.entities;

import jakarta.persistence.*;

@Entity
public class LandingStrip {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long IdLandingStrip;

	@Column
	private String numberLandingStrip;

    @Column
    private Long IdAirport;

	public LandingStrip(String numberLandingStrip, Long IdAirport) {
		this.numberLandingStrip = numberLandingStrip;
		this.IdAirport = IdAirport;
	
	}
	public Long getIdLandingStrip() {
		return this.IdLandingStrip;
	}

	public void setIdLandingStrip(Long IdLandingStrip) {
		this.IdLandingStrip = IdLandingStrip;
	}

	public String getNumberLandingStrip() {
		return this.numberLandingStrip;
	}

	public void setNumberLandingStrip(String numberLandingStrip) {
		this.numberLandingStrip = numberLandingStrip;
	}

	public Long getIdAirport() {
		return this.IdAirport;
	}

	public void setIdAirport(Long IdAirport) {
		this.IdAirport = IdAirport;
	}

}