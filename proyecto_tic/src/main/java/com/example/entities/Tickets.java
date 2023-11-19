package com.example.entities;

import jakarta.persistence.*;

@Entity
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long idTicket;

    @Column
    private String pasaport;

    @Column
    private Long idFlight;

    @Column
    private Long idAirline;


    public Long getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(Long idAirline) {
        this.idAirline = idAirline;
    }
    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long IdTicket) {
        this.idTicket = IdTicket;
    }
    public String getPasaport() {
        return pasaport;
    }

    public void setPasaport(String Pasaport) {
        this.pasaport = Pasaport;
    }

    public Long getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(Long IdFlight) {
        this.idFlight = IdFlight;
    }

}
