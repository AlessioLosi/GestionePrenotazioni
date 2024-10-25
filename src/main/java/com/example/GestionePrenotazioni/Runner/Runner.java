package com.example.GestionePrenotazioni.Runner;

import com.example.GestionePrenotazioni.Entities.*;
import com.example.GestionePrenotazioni.Service.EdificioService;
import com.example.GestionePrenotazioni.Service.PostazioniService;
import com.example.GestionePrenotazioni.Service.PrenotazioniService;
import com.example.GestionePrenotazioni.Service.UtentiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
public class Runner implements CommandLineRunner {
    @Autowired
    private UtentiService us;
    @Autowired
    private PostazioniService ps;
    @Autowired
    private PrenotazioniService prs;
    @Autowired
    private EdificioService es;


    @Override
    public void run(String... args) throws Exception {
        Utente utente1 = new Utente("GUTS", "Olivia", "Rodrigo", "olivia@rodrigo.com");
        Utente utente2 = new Utente("ERAS", "Taylor", "Swift", "taylor@swift.com");
        Utente utente3 = new Utente("SWEET", "Sabrina", "Carpenter", "sabrina@carpenter.com");
        Utente utente4 = new Utente("TSOU", "Gracie", "Abrams", "gracie@abrams.com");
        us.saveUser(utente1);
        us.saveUser(utente2);
        us.saveUser(utente3);
        us.saveUser(utente4);

        Edificio edificio1 = new Edificio("Edificio 1", "Via Trieste", "Milano");
        Edificio edificio2 = new Edificio("Edificio 2", "Via Roma", "Torino");
        Edificio edificio3 = new Edificio("Edificio 3", "Via Giolitti", "Roma");
        Edificio edificio4 = new Edificio("Edificio 4", "Via Marsala", "Firenze");
        es.saveEdificio(edificio1);
        es.saveEdificio(edificio2);
        es.saveEdificio(edificio3);
        es.saveEdificio(edificio4);


        Postazione postazione1 = new Postazione("Postazione 1", 2, TipoPostazione.SALA_RIUNIONI, edificio1);
        Postazione postazione2 = new Postazione("Postazione 2", 10, TipoPostazione.OPENSPACE, edificio1);
        Postazione postazione3 = new Postazione("Postazione 3", 34, TipoPostazione.OPENSPACE, edificio2);
        Postazione postazione4 = new Postazione("Postazione 4", 6, TipoPostazione.PRIVATO, edificio2);
        Postazione postazione5 = new Postazione("Postazione 5", 5, TipoPostazione.PRIVATO, edificio2);
        Postazione postazione6 = new Postazione("Postazione 6", 9, TipoPostazione.SALA_RIUNIONI, edificio3);
        Postazione postazione7 = new Postazione("Postazione 7", 22, TipoPostazione.SALA_RIUNIONI, edificio3);
        Postazione postazione8 = new Postazione("Postazione 8", 14, TipoPostazione.SALA_RIUNIONI, edificio4);
        Postazione postazione9 = new Postazione("Postazione 9", 1, TipoPostazione.PRIVATO, edificio4);
        Postazione postazione10 = new Postazione("Postazione 10", 8, TipoPostazione.OPENSPACE, edificio3);

        ps.savePostazione(postazione1);
        ps.savePostazione(postazione2);
        ps.savePostazione(postazione3);
        ps.savePostazione(postazione4);
        ps.savePostazione(postazione5);
        ps.savePostazione(postazione6);
        ps.savePostazione(postazione7);
        ps.savePostazione(postazione8);
        ps.savePostazione(postazione9);
        ps.savePostazione(postazione10);

        Prenotazioni prenotazione1 = new Prenotazioni(LocalDate.now(), utente1, postazione1);
        Prenotazioni prenotazione2 = new Prenotazioni(LocalDate.now().minusDays(10), utente1, postazione2);
        Prenotazioni prenotazione3 = new Prenotazioni(LocalDate.now().minusDays(1), utente2, postazione3);
        Prenotazioni prenotazione4 = new Prenotazioni(LocalDate.now().plusDays(2), utente3, postazione4);
        Prenotazioni prenotazione5 = new Prenotazioni(LocalDate.now().minusDays(4), utente4, postazione5);
        prs.savePrenotazione(prenotazione1);
        prs.savePrenotazione(prenotazione2);
        prs.savePrenotazione(prenotazione3);
        prs.savePrenotazione(prenotazione4);
        prs.savePrenotazione(prenotazione5);

        // Prenotazioni prenotazione6 = new Prenotazioni(LocalDate.now(), utente3, postazione10);
        // prs.prenotaPostazione(LocalDate.now(), postazione10, prenotazione6);


        ps.FindPostazioni("Milano", TipoPostazione.OPENSPACE).forEach(System.out::println);

        Prenotazioni prenotazione12 = new Prenotazioni(LocalDate.now(), utente1, postazione3);
        prs.SalvaPrenotazione(LocalDate.now(), utente1, prenotazione12);


    }
}
