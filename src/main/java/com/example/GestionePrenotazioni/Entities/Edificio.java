package com.example.GestionePrenotazioni.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "edificio")
public class Edificio {
    @Id
    @GeneratedValue
    protected Long id;
    protected String nome;
    protected String indirizzo;
    protected String città;
    @OneToMany(mappedBy = "edificio_id")
    private List<Postazione> postazioneList;

    public Edificio() {
    }

    public Edificio(String nome, String indirizzo, String città) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.città = città;
    }

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String nome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String indirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String città() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    @Override
    public String toString() {
        return "Edificio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", città='" + città + '\'' +
                '}';
    }
}
