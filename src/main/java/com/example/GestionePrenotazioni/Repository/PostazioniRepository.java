package com.example.GestionePrenotazioni.Repository;

import com.example.GestionePrenotazioni.Entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostazioniRepository extends JpaRepository<Postazione, Long> {

}
