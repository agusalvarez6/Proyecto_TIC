package com.example.entities;

import jakarta.persistence.*;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long IdAirport;

    @Column
    private String IATA;
    @Column
    private String name;
    @Column
    private String location;
    @Column
    private int jetBridgeNum;
    @Column
    private Long idUser;

    public String getIATA(){
        return this.IATA;
    }
    public void setIATA(String IATA){
        this.IATA = IATA;
    }
    public String getName(){
        return this.name; 
    }
    public void setName(String Name){
        this.name = Name;
    }
    public String getLocation(){
        return this.location;
    }
    public void setLocation(String Location){
        this.location = Location;
    }
    public int getJetBridgeNum(){
        return this.jetBridgeNum; 
    }
    public void setJetBridgeNum(int JetBridgeNum){
        this.jetBridgeNum = JetBridgeNum;
    }
    public Long getIdUser(){
        return this.idUser; 
    }
    public void setIdUser(Long IdUser){
        this.idUser = IdUser;
    }
}
