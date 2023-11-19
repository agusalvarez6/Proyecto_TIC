package com.example.entities;

import jakarta.persistence.*;

@Entity
public class LandingStrip {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long idLandingStrip;

	@Column
	private String numberLandingStrip;

    @Column
    private String idAirport;

	public LandingStrip(String numberLandingStrip, String IdAirport) {
		this.numberLandingStrip = numberLandingStrip;
		this.idAirport = IdAirport;
	
	}

	public LandingStrip() {
	}
	
	public Long getIdLandingStrip() {
		return this.idLandingStrip;
	}

	public void setIdLandingStrip(Long IdLandingStrip) {
		this.idLandingStrip = IdLandingStrip;
	}

	public String getNumberLandingStrip() {
		return this.numberLandingStrip;
	}

	public void setNumberLandingStrip(String numberLandingStrip) {
		this.numberLandingStrip = numberLandingStrip;
	}

	public String getIdAirport() {
		return this.idAirport;
	}

	public void setIdAirport(String IdAirport) {
		this.idAirport = IdAirport;
	}

}