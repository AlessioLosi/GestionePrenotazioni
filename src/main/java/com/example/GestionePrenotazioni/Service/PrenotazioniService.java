package com.example.GestionePrenotazioni.Service;

import com.example.GestionePrenotazioni.Entities.Postazione;
import com.example.GestionePrenotazioni.Entities.Prenotazioni;
import com.example.GestionePrenotazioni.Entities.Utente;
import com.example.GestionePrenotazioni.Repository.PostazioniRepository;
import com.example.GestionePrenotazioni.Repository.PrenotazioniRepository;
import com.example.GestionePrenotazioni.exceptions.FoundExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class PrenotazioniService {
    private static final Logger log = LoggerFactory.getLogger(PrenotazioniService.class);
    @Autowired
    private PrenotazioniRepository PrR;
    @Autowired
    private PostazioniRepository Pr;


    public void savePrenotazione(Prenotazioni newPrenotazione) {

        PrR.save(newPrenotazione);
    }

    public boolean ControlloPostazione(LocalDate data1, Postazione postazione) {
        boolean controlloData = postazione.prenotazioniList().stream().anyMatch(prenotazioni -> prenotazioni.data().equals(data1));
        if (controlloData) {
            return false;
        } else {
            return true;
        }
    }

    public void SalvaPrenotazione(LocalDate data, Utente utente, Prenotazioni newPrenotazione) {
        try {
            if (FindPrenotazioni(utente, data).isEmpty()) {
                savePrenotazione(newPrenotazione);
                System.out.println("Prenotazione effettuata");
            } else {
                throw new FoundExceptions("Hai già prenotato per oggi");
            }
        } catch (FoundExceptions e) {
            e.getMessage();
        }
    }


    public List<Prenotazioni> FindPrenotazioni(Utente utente, LocalDate data1) {
        try {
            return PrR.findAll().stream().filter(prenotazioni -> prenotazioni.utente_id().equals(utente.username()) && prenotazioni.data().equals(data1)).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public void prenotaPostazione(LocalDate data, Postazione postazione, Prenotazioni newPrenotazione) {
        try {
            if (ControlloPostazione(data, postazione)) {
                savePrenotazione(newPrenotazione);
                System.out.println("Prenotazione effettuata");
            } else {
                throw new FoundExceptions("Non è possibile prenotare una postazione già occupata");
            }
        } catch (FoundExceptions e) {
            e.getMessage();
        }
    }

}
