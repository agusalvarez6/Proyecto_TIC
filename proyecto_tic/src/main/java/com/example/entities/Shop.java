package com.example.entities;

import javax.persistence.*;

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
    private Long IdAirline;

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

	public Long getIdAirline() {
		return this.IdAirline;
	}

	public void setIdAirline(Long IdAirline) {
		this.IdAirline = IdAirline;
	}

	public Long getIdAccount() {
		return this.IdAccount;
	}

	public void setIdAccount(Long IdAccount) {
		this.IdAccount = IdAccount;
	}



}