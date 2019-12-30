package com.example.inzynier.Service;

import com.example.inzynier.Assembler.UzytkownikAssembler;
import com.example.inzynier.Assembler.ZabiteBestieAssembler;
import com.example.inzynier.DTO.ZabiteBestieDTO;
import com.example.inzynier.Repositories.ZabiteBestieRepositories;
import com.example.inzynier.tables.ZabiteBestie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ZabiteBestieService {
    //lista zabitych bestii przez danego uzytkownika
    //update create delete
    //find by uzytkownik
    @Autowired
    private ZabiteBestieRepositories zabiteBestieRepositories;
    @Autowired
    private ZabiteBestieAssembler zabiteBestieAssembler;
    @Autowired
    private UzytkownikService uzytkownikService;
    @Autowired
    private UzytkownikAssembler uzytkownikAssembler;
    public List<ZabiteBestieDTO> findByUzytkownik(String uzytkownik){
        return zabiteBestieAssembler.toDtoWithId(zabiteBestieRepositories.findByUzytkownik(uzytkownikAssembler.toEntity(uzytkownikService.findByLogin(uzytkownik))));
    }
    public ZabiteBestieDTO create(ZabiteBestieDTO zabiteBestieDTO){
        return zabiteBestieAssembler.toDtoWithId(zabiteBestieRepositories.save(zabiteBestieAssembler.toEntity(zabiteBestieDTO)));
    }
    public void delete(Integer id){
        if(!zabiteBestieRepositories.findById(id).isPresent()) throw new EntityNotFoundException("You can't delete this");
        zabiteBestieRepositories.deleteById(id);
    }
    @Transactional
    public ZabiteBestieDTO update(Integer id, ZabiteBestieDTO zabiteBestieDTO){
        if(!zabiteBestieRepositories.findById(id).isPresent()) throw new EntityNotFoundException("You can't update this");
        ZabiteBestie zabiteBestie = zabiteBestieRepositories.findById(id).get();
        zabiteBestieAssembler.updateEntity(zabiteBestie, zabiteBestieDTO);
        return zabiteBestieDTO;
    }
}
