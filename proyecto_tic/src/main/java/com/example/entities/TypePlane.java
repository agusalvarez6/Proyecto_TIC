package com.example.entities;

import jakarta.persistence.*;

@Entity
public class TypePlane {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long IdTypePlane;

    @Column
    private String Model;

    @Column
    private String Capacity;

	public Long getIdTypePlane() {
		return this.IdTypePlane;
	}

	public void setIdTypePlane(Long IdTypePlane) {
		this.IdTypePlane = IdTypePlane;
	}

	public String getModel() {
		return this.Model;
	}

	public void setModel(String Model) {
		this.Model = Model;
	}

	public String getCapacity() {
		return this.Capacity;
	}

	public void setCapacity(String Capacity) {
		this.Capacity = Capacity;
	}


}