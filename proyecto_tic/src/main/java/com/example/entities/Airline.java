package com.example.entities;

import javax.persistence.*;

@Entity
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long IdAirline;

    @Column
    private String Name;

    @Column
    private Long IdAccount;

    @Column
    private String Role;

    public Long getIdAirline() {
        return IdAirline;
    }

    public void setIdAirline(Long idAirline) {
        IdAirline = idAirline;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getIdAccount() {
        return IdAccount;
    }

    public void setIdAccount(Long idAccount) {
        IdAccount = idAccount;
    }

}
