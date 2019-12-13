package com.example.inzynier.Service;

import com.example.inzynier.Assembler.DomekAssembler;
import com.example.inzynier.DTO.DomekDTO;
import com.example.inzynier.Repositories.DomekRepositories;
import com.example.inzynier.tables.Domek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DomekService {
    @Autowired
    private DomekRepositories domekRepositories;
    @Autowired
    private DomekAssembler domekAssembler;
    //potrzebuje update create i wyszukiwanie po wlascicielu
    public DomekDTO findByWlasciciel(String login){
        return domekAssembler.toDto(domekRepositories.findById(login).get());
    }
    public DomekDTO create(DomekDTO domekDTO){
        return domekAssembler.toDto(domekRepositories.save(domekAssembler.toEntity(domekDTO)));
    }
    @Transactional
    public DomekDTO update(String wlasciciel, DomekDTO domekDTO){
        Domek domek = domekRepositories.getOne(wlasciciel);
        domekAssembler.updateEntity(domek, domekDTO);
        return domekAssembler.toDto(domek);
    }
}
