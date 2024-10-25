package com.example.GestionePrenotazioni.Service;

import com.example.GestionePrenotazioni.Entities.Utente;
import com.example.GestionePrenotazioni.Repository.UtentiRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UtentiService {
    @Autowired
    private UtentiRepository UR;

    public void saveUser(Utente newUtente) {

        UR.save(newUtente);
    }
}
