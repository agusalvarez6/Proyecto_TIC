package com.example.entities;

import jakarta.persistence.*;

@Entity
public class AirportEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long idAirportEmployee;

    @Column
    private String salary;

    @Column
    private String name;

    @Column
    private String rol;

    @Column
    private String iataAirport;

    @Column
    private Long idAccount;

	public Long getIdAirportEmployee() {
		return this.idAirportEmployee;
	}

	public void setIdAirportEmployee(Long IdAirportEmployee) {
		this.idAirportEmployee = IdAirportEmployee;
	}

	public String getSalary() {
		return this.salary;
	}

	public void setSalary(String Salary) {
		this.salary = Salary;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String Name) {
		this.name = Name;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String Rol) {
		this.rol = Rol;
	}

	public String getIataAirport() {
		return this.iataAirport;
	}

	public void setIataAirport(String IataAirport) {
		this.iataAirport = IataAirport;
	}

	public Long getIdAccount() {
		return this.idAccount;
	}

	public void setIdAccount(Long IdAccount) {
		this.idAccount = IdAccount;
	}



}