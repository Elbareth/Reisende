package com.example.inzynier.Service;

import com.example.inzynier.Assembler.ZbrojaAssembler;
import com.example.inzynier.DTO.ZbrojaDTO;
import com.example.inzynier.Repositories.ZbrojaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ZbrojaService {
    //po typie po nazwie oraz lista
    //wyszukiwanie po pliku
    //brak odyfikacji dodawania usuwania od strony kodu
    @Autowired
    private ZbrojaAssembler zbrojaAssembler;
    @Autowired
    private ZbrojaRepositories zbrojaRepositories;

    public ZbrojaDTO findByNazwa(String nazwa){
        if(!zbrojaRepositories.findByNazwa(nazwa).isPresent()) throw new EntityNotFoundException("There is no equipnent with such name");
        return zbrojaAssembler.toDto(zbrojaRepositories.findByNazwa(nazwa).get());
    }
    public ZbrojaDTO findByPlik(String plik){
        if(!zbrojaRepositories.findByPlik(plik).isPresent()) throw new EntityNotFoundException("There is no equipnent with such name");
        return zbrojaAssembler.toDto(zbrojaRepositories.findByPlik(plik).get());
    }
    public List<ZbrojaDTO> findAll(){
        return zbrojaAssembler.toDto(zbrojaRepositories.findAll());
    }
    public List<ZbrojaDTO> findByKlasa(String klasa){
        return zbrojaAssembler.toDto(zbrojaRepositories.findByKlasa(klasa));
    }
}
