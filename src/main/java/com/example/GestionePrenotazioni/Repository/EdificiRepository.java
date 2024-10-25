package com.example.GestionePrenotazioni.Repository;

import com.example.GestionePrenotazioni.Entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificiRepository extends JpaRepository<Edificio, Long> {
}
