package com.example.inzynier.Service;

import com.example.inzynier.Assembler.UzytkownikAssembler;
import com.example.inzynier.Assembler.WiadomosciAssembler;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.DTO.WiadomosciDTO;
import com.example.inzynier.Repositories.WiadomosciRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        return wiadomosciAssembler.toDtoWithId(wiadomosciRepositories.findAllByNadawcaOrderByDataAsc(uzytkownikAssembler.toEntity(uzytkownikDTO)));
    }
    public List<WiadomosciDTO> findByOdbiorca(UzytkownikDTO uzytkownikDTO){
        return wiadomosciAssembler.toDtoWithId(wiadomosciRepositories.findAllByOdbiorcaOrderByDataAsc(uzytkownikAssembler.toEntity(uzytkownikDTO)));
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
}
