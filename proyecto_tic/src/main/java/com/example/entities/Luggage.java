package com.example.entities;

import javax.persistence.*;

@Entity
public class Luggage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long IdLuggage;

    @Column
    private String Code;

    @Column
    private Long IdFlights;

    @Column
    private Long IdAccount;

	public Long getIdLuggage() {
		return this.IdLuggage;
	}

	public void setIdLuggage(Long IdLuggage) {
		this.IdLuggage = IdLuggage;
	}

	public String getCode() {
		return this.Code;
	}

	public void setCode(String Code) {
		this.Code = Code;
	}

	public Long getIdFlights() {
		return this.IdFlights;
	}

	public void setIdFlights(Long IdFlights) {
		this.IdFlights = IdFlights;
	}

	public Long getIdAccount() {
		return this.IdAccount;
	}

	public void setIdAccount(Long IdAccount) {
		this.IdAccount = IdAccount;
	}
	
}