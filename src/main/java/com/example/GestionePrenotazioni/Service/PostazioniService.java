package com.example.GestionePrenotazioni.Service;

import com.example.GestionePrenotazioni.Repository.PostazioniRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PostazioniService {
    @Autowired
    private PostazioniRepository PR;
}
