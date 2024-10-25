package com.example.GestionePrenotazioni.Repository;

import com.example.GestionePrenotazioni.Entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UtentiRepository extends JpaRepository<Utente, String> {
}
