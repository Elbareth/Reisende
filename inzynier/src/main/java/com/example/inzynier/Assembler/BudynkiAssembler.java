package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.BudynkiDTO;
import com.example.inzynier.tables.Budynki;

import java.util.ArrayList;
import java.util.List;

public class BudynkiAssembler {
    public BudynkiDTO toDto(Budynki budynki){
        return new BudynkiDTO(budynki.getNazwa(), budynki.getPolozenie(), budynki.getWymiary(), budynki.getPlik());
    }
    public List<BudynkiDTO> toDto(List<Budynki> listaBudynki){
        List<BudynkiDTO> listaBudynkiDto = new ArrayList<BudynkiDTO>();
        listaBudynki.forEach(param ->{
            listaBudynkiDto.add(toDto(param));
        });
        return listaBudynkiDto;
    }
    public Budynki toEntity(BudynkiDTO budynkiDTO){
        return new Budynki(budynkiDTO.getNazwa(), budynkiDTO.getPolozenie(), budynkiDTO.getWymiary(), budynkiDTO.getPlik());
    }
    public List<Budynki> toEntity(List<BudynkiDTO> listaBudynkiDto){
        List<Budynki> listaBudynki = new ArrayList<Budynki>();
        listaBudynkiDto.forEach(param ->{
            listaBudynki.add(toEntity(param));
        });
        return listaBudynki;
    }
}
