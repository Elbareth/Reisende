package com.example.inzynier.Service;

import com.example.inzynier.Assembler.WygladPostaciAssembler;
import com.example.inzynier.DTO.WygladPostaciDTO;
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
    @Autowired
    private WygladPostaciAssembler wygladPostaciAssembler;
    //wyszukiwanie po id i lista
    //brak modyfikacji dodawania i usuwania
    public WygladPostaciDTO findById(Integer id){
        if(!wygladPostaciRepositories.findById(id).isPresent()) throw new EntityNotFoundException("Nie ma takiego wygladu postaci");
        return wygladPostaciAssembler.toDto(wygladPostaciRepositories.findById(id).get());
    }
    public WygladPostaciDTO findByNazwa(String nazwa){
        if(!wygladPostaciRepositories.findByNazwa(nazwa).isPresent()) throw new EntityNotFoundException("Nie ma takiego wygladu postaci");
        return wygladPostaciAssembler.toDtoWithId(wygladPostaciRepositories.findByNazwa(nazwa).get());
    }
    public WygladPostaciDTO findByPlik(String plik){
        if(!wygladPostaciRepositories.findByPlik(plik).isPresent()) throw new EntityNotFoundException("Nie ma takiego wygladu postaci");
        return wygladPostaciAssembler.toDto(wygladPostaciRepositories.findByPlik(plik).get());
    }
    public List<WygladPostaciDTO> findAll(){
        return wygladPostaciAssembler.toDto(wygladPostaciRepositories.findAll());
    }
}
