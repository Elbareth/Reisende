package com.example.inzynier.Service;

import com.example.inzynier.Repositories.WygladPostaciRepositories;
import com.example.inzynier.tables.WygladPostaci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import javax.persistence.EntityNotFoundException;

@Service
public class WygladPostaciService {

    @Autowired
    private WygladPostaciRepositories wygladPostaciRepositories;
    //wyszukiwanie po id i lista
    //brak modyfikacji dodawania i usuwania
    public WygladPostaci findById(Integer id){
        if(!wygladPostaciRepositories.findById(id).isPresent()) throw new EntityNotFoundException("Nie ma takiego wygladu postaci");
        return wygladPostaciRepositories.findById(id).get();
    }
    public WygladPostaci findByNazwa(String nazwa){
        if(!wygladPostaciRepositories.findByNazwa(nazwa).isPresent()) throw new EntityNotFoundException("Nie ma takiego wygladu postaci");
        return wygladPostaciRepositories.findByNazwa(nazwa).get();
    }
    public WygladPostaci findByPlik(String plik){
        if(!wygladPostaciRepositories.findByPlik(plik).isPresent()) throw new EntityNotFoundException("Nie ma takiego wygladu postaci");
        return wygladPostaciRepositories.findByPlik(plik).get();
    }
    public List<WygladPostaci> findAll(){
        return wygladPostaciRepositories.findAll();
    }
}
