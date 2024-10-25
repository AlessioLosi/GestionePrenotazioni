package com.example.GestionePrenotazioni.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "utente")

public class Utente {
    @Id
    protected String username;
    protected String nome;
    protected String cognome;
    @Column(nullable = false)
    protected String email;
    @OneToMany(mappedBy = "utente_id")
    private List<Prenotazioni> prenotazioniList;

    public Utente() {
    }

    public Utente(String username, String nome, String cognome, String email) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }

    public String username() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String nome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String cognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "username='" + username + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
