package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.EkwipunekDTO;
import com.example.inzynier.tables.Ekwipunek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EkwipunekAssembler {
    @Autowired
    private UzytkownikAssembler uzytkownikAssembler;
    public EkwipunekDTO toDto(Ekwipunek ekwipunek){
        return new EkwipunekDTO(uzytkownikAssembler.toDto(ekwipunek.getWlasciciel()), ekwipunek.getNazwa(), ekwipunek.getPlik(), ekwipunek.getOpis());
    }
    public List<EkwipunekDTO> toDto(List<Ekwipunek> listaEkwipunek){
        List<EkwipunekDTO> listaEkwipunekDTO = new ArrayList<>();
        listaEkwipunek.forEach(param ->{
            listaEkwipunekDTO.add(toDto(param));
        });
        return listaEkwipunekDTO;
    }
    public EkwipunekDTO toDtoWithId(Ekwipunek ekwipunek){
        return new EkwipunekDTO(ekwipunek.getId(), uzytkownikAssembler.toDto(ekwipunek.getWlasciciel()), ekwipunek.getNazwa(), ekwipunek.getPlik(), ekwipunek.getOpis());
    }
    public List<EkwipunekDTO> toDtoWithId(List<Ekwipunek> listaEkwipunek){
        List<EkwipunekDTO> listaEkwipunekDTO = new ArrayList<>();
        listaEkwipunek.forEach(param ->{
            listaEkwipunekDTO.add(toDtoWithId(param));
        });
        return listaEkwipunekDTO;
    }
    public Ekwipunek toEntity(EkwipunekDTO ekwipunekDTO){
        return new Ekwipunek(uzytkownikAssembler.toEntity(ekwipunekDTO.getWlasciciel()), ekwipunekDTO.getNazwa(), ekwipunekDTO.getPlik(), ekwipunekDTO.getOpis());
    }
    public List<Ekwipunek> toEntity(List<EkwipunekDTO> listaEkwipunekDto){
        List<Ekwipunek> listaEkwipunek = new ArrayList<>();
        listaEkwipunekDto.forEach(param ->{
            listaEkwipunek.add(toEntity(param));
        });
        return listaEkwipunek;
    }
    public void updateEntity(Ekwipunek ekwipunek, EkwipunekDTO ekwipunekDTO){
        ekwipunek.setNazwa(ekwipunekDTO.getNazwa());
        ekwipunek.setOpis(ekwipunekDTO.getOpis());
        ekwipunek.setPlik(ekwipunekDTO.getPlik());
        ekwipunek.setWlasciciel(uzytkownikAssembler.toEntity(ekwipunekDTO.getWlasciciel()));
    }
}
