package com.example.GestionePrenotazioni.Entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "postazione")
public class Postazione {
    @Id
    @GeneratedValue
    private Long id;
    private String descrizione;
    private int numeroMaxPartecipanti;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;
    @ManyToOne
    @JoinColumn(name = "edificio")
    private Edificio edificio_id;
    @OneToMany(mappedBy = "postazione_id")
    private List<Prenotazioni> prenotazioniList;

    public Postazione() {
    }

    public Postazione(String descrizione, int numeroMaxPartecipanti, TipoPostazione tipoPostazione, Edificio edificio_id) {
        this.descrizione = descrizione;
        this.numeroMaxPartecipanti = numeroMaxPartecipanti;
        this.tipoPostazione = tipoPostazione;
        this.edificio_id = edificio_id;
    }

    public Long id() {
        return id;
    }

    public List<Prenotazioni> prenotazioniList() {
        return prenotazioniList;
    }

    public void setPrenotazioniList(List<Prenotazioni> prenotazioniList) {
        this.prenotazioniList = prenotazioniList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String descrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int numeroMaxPartecipanti() {
        return numeroMaxPartecipanti;
    }

    public void setNumeroMaxPartecipanti(int numeroMaxPartecipanti) {
        this.numeroMaxPartecipanti = numeroMaxPartecipanti;
    }

    public TipoPostazione tipoPostazione() {
        return tipoPostazione;
    }

    public void setTipoPostazione(TipoPostazione tipoPostazione) {
        this.tipoPostazione = tipoPostazione;
    }

    public Edificio edificio() {
        return edificio_id;
    }

    public void setEdificio_id(Edificio edificio) {
        this.edificio_id = edificio;
    }

    @Override
    public String toString() {
        return "Postazione{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", numeroMaxPartecipanti=" + numeroMaxPartecipanti +
                ", tipoPostazione=" + tipoPostazione +
                ", edificio_id=" + edificio_id +
                '}';
    }
}
