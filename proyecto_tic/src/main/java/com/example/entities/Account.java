package com.example.entities;

import jakarta.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idAccount; // Cambiado de IdAccount a idAccount

    @Column
    private String username; // Cambiado de Username a username

    @Column
    private String password; // Cambiado de Password a password

    @Column
    private String role;

    @Column
    private String passport;

    public Long getIdAccount() { // Cambiado de getIdUser a getIdAccount
        return idAccount;
    }

    public void setIdAccount(Long idAccount) { // Cambiado de setIdUser a setIdAccount
        this.idAccount = idAccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String Passport) {
        this.passport = Passport;
    }
}
