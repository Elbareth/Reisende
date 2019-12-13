package com.example.inzynier.Service;

import com.example.inzynier.Assembler.PostacAssembler;
import com.example.inzynier.Assembler.ZadaniaAssembler;
import com.example.inzynier.DTO.ZadaniaDTO;
import com.example.inzynier.Repositories.ZadaniaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ZadaniaService {
    //wyszukiwanie po nazwie i postaci oraz lista
    //brak modyfkikacji dodawania oraz usuwania od strony kodu
    @Autowired
    private ZadaniaRepositories zadaniaRepositories;
    @Autowired
    private ZadaniaAssembler zadaniaAssembler;
    @Autowired
    private PostacService postacService;
    @Autowired
    private PostacAssembler postacAssembler;

    public ZadaniaDTO findByNazwa(String nazwa){
        if(!zadaniaRepositories.findByNazwa(nazwa).isPresent()) throw new EntityNotFoundException("Can't find quest by name");
        return zadaniaAssembler.toDto(zadaniaRepositories.findByNazwa(nazwa).get());
    }
    public List<ZadaniaDTO> findByPostac(String postac){
        return zadaniaAssembler.toDto(zadaniaRepositories.findByPostac(postacAssembler.toEntity(postacService.findByImie(postac))));
    }
    public List<ZadaniaDTO> findAll(){
        return zadaniaAssembler.toDto(zadaniaRepositories.findAll());
    }
}
