package com.example.entities;

import jakarta.persistence.*;

@Entity
public class Airport {
    @Id
    private String iATA;
    @Column
    private String name;
    @Column
    private String location;
    @Column
    private int jetBridgeNum;
    @Column
    private Long idUser;

    public String getIATA(){
        return this.iATA
    }
    public void setIATA(String IATA){
        this.iATA = IATA
    }
    public String getName(){
        return this.name 
    }
    public void setName(String Name){
        this.name = Name
    }
    public String getLocation(){
        return this.location
    }
    public void setLocation(String Location){
        this.location = Location
    }
    public int getJetBridgeNum(){
        return this.jetBridgeNum 
    }
    public void setJetBridgeNum(int JetBridgeNum){
        this.jetBridgeNum = JetBridgeNum
    }
    public Long getIdUser(){
        return this.idUser 
    }
    public void setIdUser(Long IdUser){
        this.idUser = IdUser
    }
}

