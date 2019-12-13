package com.example.inzynier.Service;

import com.example.inzynier.Assembler.EkwipunekAssembler;
import com.example.inzynier.Assembler.UzytkownikAssembler;
import com.example.inzynier.DTO.EkwipunekDTO;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.Repositories.EkwipunekRepositories;
import com.example.inzynier.tables.Ekwipunek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class EkwipunekService {
    //otrzebuje dodawanie usuwanie edytowanie
    //wyszukiwanie po id i po wlascicielu
    @Autowired
    private EkwipunekAssembler ekwipunekAssembler;
    @Autowired
    private EkwipunekRepositories ekwipunekRepositories;
    @Autowired
    private UzytkownikAssembler uzytkownikAssembler;

    public EkwipunekDTO create(EkwipunekDTO ekwipunekDTO){
        return ekwipunekAssembler.toDto(ekwipunekRepositories.save(ekwipunekAssembler.toEntity(ekwipunekDTO)));
    }
    public void delete(Integer id){
        if(!ekwipunekRepositories.findById(id).isPresent()) throw new EntityNotFoundException("Can't find id of ekwipunek");
        ekwipunekRepositories.deleteById(id);
    }
    @Transactional
    public EkwipunekDTO update(Integer id, EkwipunekDTO ekwipunekDTO){
        if(!ekwipunekRepositories.findById(id).isPresent()) throw new EntityNotFoundException("Can't find id of ekwipunek");
        Ekwipunek ekwipunek = ekwipunekRepositories.findById(id).get();
        ekwipunekAssembler.updateEntity(ekwipunek,ekwipunekDTO);
        return ekwipunekDTO;
    }
    public EkwipunekDTO findById(Integer id){
        if(!ekwipunekRepositories.findById(id).isPresent()) throw new EntityNotFoundException("Can't find id of ekwipunek");
        return ekwipunekAssembler.toDto(ekwipunekRepositories.findById(id).get());
    }
    public List<EkwipunekDTO> findByWlasciciel(UzytkownikDTO wlasciciel){
        if(!ekwipunekRepositories.findByWlasciciel(uzytkownikAssembler.toEntity(wlasciciel)).isPresent()) throw new EntityNotFoundException("Can't find id of ekwipunek");
        return ekwipunekAssembler.toDtoWithId(ekwipunekRepositories.findByWlasciciel(uzytkownikAssembler.toEntity(wlasciciel)).get());
    }
    public List<EkwipunekDTO> findByWlascicielAndNazwa(UzytkownikDTO wlasciciel, String nazwa){
        if(!ekwipunekRepositories.findByWlascicielAndNazwa(uzytkownikAssembler.toEntity(wlasciciel), nazwa).isPresent()) throw new EntityNotFoundException("Can't find id of ekwipunek");
        return ekwipunekAssembler.toDtoWithId(ekwipunekRepositories.findByWlascicielAndNazwa(uzytkownikAssembler.toEntity(wlasciciel), nazwa).get());
    }
}
