package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.BestieDTO;
import com.example.inzynier.tables.Bestie;

import java.util.ArrayList;
import java.util.List;

public class BestieAssembler {
    public BestieDTO toDto(Bestie bestie){
        return new BestieDTO(bestie.getNazwa(), bestie.getPlik(), bestie.getPolozenie(), bestie.getWymiary());
    }
    public List<BestieDTO> toDto(List<Bestie> listaBestii){
        List<BestieDTO> listaBestieDto = new ArrayList<BestieDTO>();
        listaBestii.forEach(param ->{
               listaBestieDto.add(toDto(param));
        });
        return listaBestieDto;
    }
    public Bestie toEntity(BestieDTO bestieDTO){
        return new Bestie(bestieDTO.getNazwa(), bestieDTO.getPlik(), bestieDTO.getPolozenie(), bestieDTO.getWymiary());
    }
    public List<Bestie> toEntity(List<BestieDTO> listaBestiiDTO){
        List<Bestie> listaBestie = new ArrayList<>();
        listaBestiiDTO.forEach(param ->{
            listaBestie.add(toEntity(param));
        });
        return listaBestie;
    }
}
