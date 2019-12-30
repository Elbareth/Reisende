package com.example.inzynier.Service;

import com.example.inzynier.Assembler.KsiazkiAssembler;
import com.example.inzynier.DTO.KsiazkiDTO;
import com.example.inzynier.Repositories.KsiazkiRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class KsiazkiService {
    //nie bede dodawac edytowac ani usuwac ksiazek z poziomu odu
    //bede wyszukiwac po id i do nazwy i lista
    @Autowired
    private KsiazkiRepositories ksiazkiRepositories;
    @Autowired
    private KsiazkiAssembler ksiazkiAssembler;
    public KsiazkiDTO findById(Integer id){
        if(!ksiazkiRepositories.findById(id).isPresent()) throw new EntityNotFoundException("There is no book with that id");
        return ksiazkiAssembler.toDtoWithId(ksiazkiRepositories.findById(id).get());
    }
    public KsiazkiDTO findByNazwa(String nazwa){
        if(!ksiazkiRepositories.findByNazwa(nazwa).isPresent()) throw new EntityNotFoundException("There is no book with that name");
        return ksiazkiAssembler.toDtoWithId(ksiazkiRepositories.findByNazwa(nazwa).get());
    }
    public List<KsiazkiDTO> findAll(){
        return ksiazkiAssembler.toDtoWithId(ksiazkiRepositories.findAll());
    }
}
