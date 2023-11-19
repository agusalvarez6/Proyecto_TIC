package com.example.entities;

import jakarta.persistence.*;

@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long IdShop;

    @Column
    private String Type;

    @Column
    private String ShopName;

    @Column
    private String iataAirport;

    @Column
    private Long IdAccount;

	public Long getIdShop() {
		return this.IdShop;
	}

	public void setIdShop(Long IdShop) {
		this.IdShop = IdShop;
	}

	public String getType() {
		return this.Type;
	}

	public void setType(String Type) {
		this.Type = Type;
	}

	public String getShopName() {
		return this.ShopName;
	}

	public void setShopName(String ShopName) {
		this.ShopName = ShopName;
	}

	public String getIataAirport() {
		return this.iataAirport;
	}

	public void setIataAirport(String IataAirport) {
		this.iataAirport = IataAirport;
	}

	public Long getIdAccount() {
		return this.IdAccount;
	}

	public void setIdAccount(Long IdAccount) {
		this.IdAccount = IdAccount;
	}



}