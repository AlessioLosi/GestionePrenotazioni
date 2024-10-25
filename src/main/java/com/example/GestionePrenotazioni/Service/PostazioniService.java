package com.example.GestionePrenotazioni.Service;

import com.example.GestionePrenotazioni.Entities.Postazione;
import com.example.GestionePrenotazioni.Entities.TipoPostazione;
import com.example.GestionePrenotazioni.Repository.PostazioniRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostazioniService {
    private static final Logger log = LoggerFactory.getLogger(PrenotazioniService.class);
    @Autowired
    private PostazioniRepository PR;

    public void savePostazione(Postazione newPostazione) {

        PR.save(newPostazione);
    }

    public List<Postazione> FindPostazioni(String città1, TipoPostazione tipo) {
        try {
            return PR.findAll().stream().filter(postazione -> postazione.edificio().città().equals(città1) && postazione.tipoPostazione().equals(tipo)).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

}
