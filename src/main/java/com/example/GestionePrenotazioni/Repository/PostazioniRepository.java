package com.example.GestionePrenotazioni.Repository;

import com.example.GestionePrenotazioni.Entities.Postazione;
import com.example.GestionePrenotazioni.Entities.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioniRepository extends JpaRepository<Postazione, Long> {
    List<Postazione> findByCittaETipo(String citta, TipoPostazione tipoPostazione);
}
