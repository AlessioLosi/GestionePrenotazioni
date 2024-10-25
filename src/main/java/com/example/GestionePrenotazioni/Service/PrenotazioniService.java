package com.example.GestionePrenotazioni.Service;

import com.example.GestionePrenotazioni.Entities.Prenotazioni;
import com.example.GestionePrenotazioni.Repository.PrenotazioniRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrenotazioniService {
    @Autowired
    private PrenotazioniRepository PrR;


    public void savePrenotazione(Prenotazioni newPrenotazione) {

        PrR.save(newPrenotazione);
    }
}
