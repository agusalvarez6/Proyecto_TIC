package com.example.entities;

import jakarta.persistence.*;

@Entity
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long idAirline;

    @Column
    private String name;

    @Column
    private Long idAccount;


    public Long getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(Long idAirline) {
        this.idAirline = idAirline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

}
