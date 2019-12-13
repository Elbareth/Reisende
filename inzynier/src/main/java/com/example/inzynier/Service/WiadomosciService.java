package com.example.inzynier.Service;

import com.example.inzynier.Assembler.UzytkownikAssembler;
import com.example.inzynier.Assembler.WiadomosciAssembler;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.DTO.WiadomosciDTO;
import com.example.inzynier.Repositories.WiadomosciRepositories;
import com.example.inzynier.tables.Wiadomosci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.*;

@Service
public class WiadomosciService {
    @Autowired
    private WiadomosciRepositories wiadomosciRepositories;
    @Autowired
    private UzytkownikAssembler uzytkownikAssembler;
    @Autowired
    private WiadomosciAssembler wiadomosciAssembler;

    public List<WiadomosciDTO> findByNadawca(UzytkownikDTO uzytkownikDTO){
        return wiadomosciAssembler.toDtoWithId(wiadomosciRepositories.findAllByNadawcaOrderByDataDesc(uzytkownikAssembler.toEntity(uzytkownikDTO)));
    }
    public List<WiadomosciDTO> findByOdbiorca(UzytkownikDTO uzytkownikDTO){
        return wiadomosciAssembler.toDtoWithId(wiadomosciRepositories.findAllByOdbiorcaOrderByDataDesc(uzytkownikAssembler.toEntity(uzytkownikDTO)));
    }
    public WiadomosciDTO findById(Integer id){
        return wiadomosciAssembler.toDtoWithId(wiadomosciRepositories.findById(id).get());
    }
    public WiadomosciDTO createWiadomosc(WiadomosciDTO wiadomosciDTO){
        return wiadomosciAssembler.toDto(wiadomosciRepositories.save(wiadomosciAssembler.toEntity(wiadomosciDTO)));
    }
    public void deleteWiadomosc(Integer id){
        if(!wiadomosciRepositories.existsById(id)) throw new EntityNotFoundException("There's no such wiadomosc");
        wiadomosciRepositories.deleteById(id);
    }
    @Transactional
    public WiadomosciDTO update(Integer id, WiadomosciDTO wiadomosciDTO){
        if(!wiadomosciRepositories.findById(id).isPresent()) throw new EntityNotFoundException("There is no message with that id");
        Wiadomosci wiadomosci = wiadomosciRepositories.findById(id).get();
        wiadomosciAssembler.updateEntity(wiadomosci, wiadomosciDTO);
        return wiadomosciDTO;
    }
}
