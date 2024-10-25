package com.example.GestionePrenotazioni.Service;

import com.example.GestionePrenotazioni.Entities.Postazione;
import com.example.GestionePrenotazioni.Entities.TipoPostazione;
import com.example.GestionePrenotazioni.Repository.PostazioniRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class PostazioniService {
    private static final Logger log = LoggerFactory.getLogger(PrenotazioniService.class);
    @Autowired
    private PostazioniRepository PR;

    public void savePostazione(Postazione newPostazione) {

        PR.save(newPostazione);
    }

    public List<Postazione> findPostazioni(TipoPostazione tipo, String citta) {
        try {
            return PR.findByCittaETipo(citta, tipo);
        } catch (Exception e) {
            log.error("Non è stato trovato nessun elemento", e);
            ;
            return List.of();
        }
    }
}
