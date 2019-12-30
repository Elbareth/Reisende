package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.ZabiteBestieDTO;
import com.example.inzynier.Service.BestieService;
import com.example.inzynier.Service.UzytkownikService;
import com.example.inzynier.tables.ZabiteBestie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ZabiteBestieAssembler {
    @Autowired
    private UzytkownikService uzytkownikService;
    @Autowired
    private UzytkownikAssembler uzytkownikAssembler;
    @Autowired
    private BestieService bestieService;
    @Autowired
    private BestieAssembler bestieAssembler;
    public ZabiteBestieDTO toDto(ZabiteBestie zabiteBestie){
        return new ZabiteBestieDTO(zabiteBestie.getUzytkownik().getLogin(), zabiteBestie.getNazwaBestii().getNazwa(), zabiteBestie.getIlosc());
    }
    public List<ZabiteBestieDTO> toDto(List<ZabiteBestie> listaZabiteBestie){
        List<ZabiteBestieDTO> listaZabiteBestieDTO = new ArrayList<>();
        listaZabiteBestie.forEach(param ->{
            listaZabiteBestieDTO.add(toDto(param));
        });
        return listaZabiteBestieDTO;
    }
    public ZabiteBestieDTO toDtoWithId(ZabiteBestie zabiteBestie){
        return new ZabiteBestieDTO(zabiteBestie.getId(), zabiteBestie.getUzytkownik().getLogin(), zabiteBestie.getNazwaBestii().getNazwa(), zabiteBestie.getIlosc());
    }
    public List<ZabiteBestieDTO> toDtoWithId(List<ZabiteBestie> listaZabiteBestie){
        List<ZabiteBestieDTO> listaZabiteBestieDTO = new ArrayList<>();
        listaZabiteBestie.forEach(param ->{
            listaZabiteBestieDTO.add(toDtoWithId(param));
        });
        return listaZabiteBestieDTO;
    }
    public ZabiteBestie toEntity(ZabiteBestieDTO zabiteBestieDTO){
        return new ZabiteBestie(zabiteBestieDTO.getId(),
                uzytkownikAssembler.toEntity(uzytkownikService.findByLogin(zabiteBestieDTO.getUzytkownik())),
                bestieAssembler.toEntity(bestieService.findByNazwa(zabiteBestieDTO.getNazwaBestii())),
                zabiteBestieDTO.getIlosc());
    }
    public List<ZabiteBestie> toEntity(List<ZabiteBestieDTO> listaZabiteBestieDto){
        List<ZabiteBestie> listaZabiteBestie = new ArrayList<>();
        listaZabiteBestieDto.forEach(param ->{
            listaZabiteBestie.add(toEntity(param));
        });
        return listaZabiteBestie;
    }
    public void updateEntity(ZabiteBestie zabiteBestie, ZabiteBestieDTO zabiteBestieDTO){
        zabiteBestie.setIlosc(zabiteBestieDTO.getIlosc());
        zabiteBestie.setNazwaBestii(bestieAssembler.toEntity(bestieService.findByNazwa(zabiteBestieDTO.getNazwaBestii())));
        zabiteBestie.setUzytkownik(uzytkownikAssembler.toEntity(uzytkownikService.findByLogin(zabiteBestieDTO.getUzytkownik())));
    }
}
