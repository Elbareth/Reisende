package com.example.inzynier.Service;

import com.example.inzynier.Assembler.EliksirAssembler;
import com.example.inzynier.DTO.EliksirDTO;
import com.example.inzynier.Repositories.EliksirRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EliksirService {
    //nie bede dodawac edytowac ani usuwac z kodu
    //bede wyszukiwac po nazwie po pliku i wszystkie
    @Autowired
    private EliksirRepositories eliksirRepositories;
    @Autowired
    private EliksirAssembler eliksirAssembler;
    public EliksirDTO findByNazwa(String nazwa){
        if(!eliksirRepositories.findByNazwa(nazwa).isPresent()) throw new EntityNotFoundException(("There is no such thing"));
        return eliksirAssembler.toDto(eliksirRepositories.findByNazwa(nazwa).get());
    }
    public EliksirDTO findByPlik(String plik){
        if(!eliksirRepositories.findByPlik(plik).isPresent()) throw new EntityNotFoundException(("There is no such thing"));
        return eliksirAssembler.toDto(eliksirRepositories.findByPlik(plik).get());
    }
    public List<EliksirDTO> findAll(){
        return eliksirAssembler.toDto(eliksirRepositories.findAll());
    }
}
