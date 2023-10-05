package com.example.entities;

import javax.persistence.*;

@Entity
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long IdFee;

    @Column
    private String Type;

    @Column
    private String Price;

    @Column
    private Long IdAirline;

	public Long getIdFee() {
		return this.IdFee;
	}

	public void setIdFee(Long IdFee) {
		this.IdFee = IdFee;
	}

	public String getType() {
		return this.Type;
	}

	public void setType(String Type) {
		this.Type = Type;
	}

	public String getPrice() {
		return this.Price;
	}

	public void setPrice(String Price) {
		this.Price = Price;
	}

	public Long getIdAirline() {
		return this.IdAirline;
	}

	public void setIdAirline(Long IdAirline) {
		this.IdAirline = IdAirline;
	}
}