package com.example.entities;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long IdUser;

    @Column
    private String Username;

    @Column
    private String Password;

    @Column
    private String Role;

    public Long getIdUser() {
        return IdUser;
    }

    public void setIdUser(Long idUser) {
        IdUser = idUser;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}
