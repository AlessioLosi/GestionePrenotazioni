package com.example.GestionePrenotazioni.Repository;

import com.example.GestionePrenotazioni.Entities.Prenotazioni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazioni, Long> {
}
