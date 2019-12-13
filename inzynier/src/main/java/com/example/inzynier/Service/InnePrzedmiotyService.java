package com.example.inzynier.Service;

import com.example.inzynier.Assembler.InnePrzedmiotyAssembler;
import com.example.inzynier.DTO.InnePrzedmiotyDTO;
import com.example.inzynier.Repositories.InnePrzedmiotyRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class InnePrzedmiotyService {
    //nie bede tworzyc usuwac ani edytowac elementow
    //bede wyszukiwac po nazwie i po pliku oraz wszystkie
    @Autowired
    private InnePrzedmiotyRepositories innePrzedmiotyRepositories;
    @Autowired
    private InnePrzedmiotyAssembler innePrzedmiotyAssembler;
    public InnePrzedmiotyDTO findByNazwa(String nazwa){
        if(!innePrzedmiotyRepositories.findByNazwa(nazwa).isPresent()) throw new EntityNotFoundException("There is no thing with that name");
        return innePrzedmiotyAssembler.toDto(innePrzedmiotyRepositories.findByNazwa(nazwa).get());
    }
    public InnePrzedmiotyDTO findByPlik(String plik){
        if(!innePrzedmiotyRepositories.findByPlik(plik).isPresent()) throw new EntityNotFoundException("There is no thig with such file");
        return innePrzedmiotyAssembler.toDto(innePrzedmiotyRepositories.findByPlik(plik).get());
    }
    public List<InnePrzedmiotyDTO> findAll(){
        return innePrzedmiotyAssembler.toDto(innePrzedmiotyRepositories.findAll());
    }
}
