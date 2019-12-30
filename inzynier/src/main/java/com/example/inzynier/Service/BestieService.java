package com.example.inzynier.Service;

import com.example.inzynier.Assembler.BestieAssembler;
import com.example.inzynier.DTO.BestieDTO;
import com.example.inzynier.Repositories.BestieRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BestieService {
    //z poziomu kodu nie bede dodawac, usuwac ani modyfikowac bestii
    //bede jedynie czytywac o nich informacje na podstawie nazwy bestii
    //oraz potrzebuje listy wszystkich bestii i po planszy
    @Autowired
    private BestieRepositories bestieRepositories;
    @Autowired
    private BestieAssembler bestieAssembler;
    public BestieDTO findByNazwa(String nazwa){
        if(!bestieRepositories.findByNazwa(nazwa).isPresent()) throw new EntityNotFoundException("There is no beast with that name");
        return bestieAssembler.toDtoWithId(bestieRepositories.findByNazwa(nazwa).get());
    }
    public List<BestieDTO> findAll(){
        return bestieAssembler.toDtoWithId(bestieRepositories.findAll());
    }
    public List<BestieDTO> findByPlansza(String plansza){
        List<BestieDTO> listaBestii = new ArrayList<>();
        bestieAssembler.toDtoWithId(bestieRepositories.findAll()).forEach( it->{
            if(it.getPlansza().equals(plansza)){
                listaBestii.add(it);
            }
        });
        return listaBestii;
    }

}
