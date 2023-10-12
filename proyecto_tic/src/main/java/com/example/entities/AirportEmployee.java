package com.example.entities;

import jakarta.persistence.*;

@Entity
public class AirportEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long IdAirportEmployee;

    @Column
    private String Salary;

    @Column
    private String Name;

    @Column
    private String Rol;

    @Column
    private Long IdAirline;

    @Column
    private Long IdAccount;

	public Long getIdAirportEmployee() {
		return this.IdAirportEmployee;
	}

	public void setIdAirportEmployee(Long IdAirportEmployee) {
		this.IdAirportEmployee = IdAirportEmployee;
	}

	public String getSalary() {
		return this.Salary;
	}

	public void setSalary(String Salary) {
		this.Salary = Salary;
	}

	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getRol() {
		return this.Rol;
	}

	public void setRol(String Rol) {
		this.Rol = Rol;
	}

	public Long getIdAirline() {
		return this.IdAirline;
	}

	public void setIdAirline(Long IdAirline) {
		this.IdAirline = IdAirline;
	}

	public Long getIdAccount() {
		return this.IdAccount;
	}

	public void setIdAccount(Long IdAccount) {
		this.IdAccount = IdAccount;
	}



}