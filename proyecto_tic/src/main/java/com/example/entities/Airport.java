package com.example.entities;

import jakarta.persistence.*;

@Entity
public class Airport {
    @Id
    private Long IATA;
    @Column
    private String Name;
    @Column
    private String Location;
    @Column
    private int JetBridgeNum;
    @Column
    private Long IdUser;

}
