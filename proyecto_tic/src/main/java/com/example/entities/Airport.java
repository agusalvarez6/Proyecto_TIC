package com.example.entities;

import jakarta.persistence.*;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long IdAirport;

    @Column
    private String iATA;
    @Column
    private String name;
    @Column
    private String country;
    @Column
    private String city;
    @Column
    private int jetBridgeNum;
    @Column
    private Long idAccount;

    public Long  getIdAirport() {
        return this.IdAirport;
    }
    public void setIdAirport(Long IdAirport) {
        this.IdAirport = IdAirport;
    }
    public String getIATA(){
        return this.iATA;
    }
    public void setIATA(String IATA){
        this.iATA = IATA;
    }
    public String getName(){
        return this.name; 
    }
    public void setName(String Name){
        this.name = Name;
    }
    public String getCountry(){
        return this.country; 
    }
    public void setCountry(String Country){
        this.country = Country;
    }
    public String getCity(){
        return this.city; 
    }
    public void setCity(String City){
        this.city = City;
    }
    public int getJetBridgeNum(){
        return this.jetBridgeNum; 
    }
    public void setJetBridgeNum(int JetBridgeNum){
        this.jetBridgeNum = JetBridgeNum;
    }
    public Long getIdAccount(){
        return this.idAccount; 
    }
    public void setIdAccount(Long IdAccount){
        this.idAccount = IdAccount;
    }
}
