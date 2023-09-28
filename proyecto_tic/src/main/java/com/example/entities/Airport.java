package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
