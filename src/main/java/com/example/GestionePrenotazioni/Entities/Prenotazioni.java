package com.example.GestionePrenotazioni.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")
public class Prenotazioni {
    @Id
    @GeneratedValue
    protected Long id;
    protected LocalDate data;
    @ManyToOne
    @JoinColumn(name = "utente")
    private Utente utente_id;
    @ManyToOne
    @JoinColumn(name = "postazione")
    private Postazione postazione_id;

    public Prenotazioni() {
    }

    public Prenotazioni(LocalDate data, Utente utente_id, Postazione postazione_id) {
        this.data = data;
        this.utente_id = utente_id;
        this.postazione_id = postazione_id;
    }

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate data() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Utente utente_id() {
        return utente_id;
    }

    public void setUtente_id(Utente utente_id) {
        this.utente_id = utente_id;
    }

    public Postazione postazione_id() {
        return postazione_id;
    }

    public void setPostazione_id(Postazione postazione_id) {
        this.postazione_id = postazione_id;
    }

    @Override
    public String toString() {
        return "Prenotazioni{" +
                "id=" + id +
                ", data=" + data +
                ", utente_id=" + utente_id +
                ", postazione_id=" + postazione_id +
                '}';
    }
}
