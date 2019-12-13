package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.BudynkiDTO;
import com.example.inzynier.tables.Budynki;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BudynkiAssembler {
    public BudynkiDTO toDto(Budynki budynki){
        String [] plansza = budynki.getPolozenie().split("-");
        String [] wymiar = plansza[1].split("x");
        return new BudynkiDTO(budynki.getNazwa(), plansza[0], wymiar[0], wymiar[1], budynki.getWymiary(), budynki.getPlik());
    }
    public List<BudynkiDTO> toDto(List<Budynki> listaBudynki){
        List<BudynkiDTO> listaBudynkiDto = new ArrayList<BudynkiDTO>();
        listaBudynki.forEach(param ->{
            listaBudynkiDto.add(toDto(param));
        });
        return listaBudynkiDto;
    }
    public Budynki toEntity(BudynkiDTO budynkiDTO){
        return new Budynki(budynkiDTO.getNazwa(), budynkiDTO.getPlansza()+"-"+budynkiDTO.getPolozenieX()+"x"+budynkiDTO.getPolozenieY(), budynkiDTO.getWymiary(), budynkiDTO.getPlik());
    }
    public List<Budynki> toEntity(List<BudynkiDTO> listaBudynkiDto){
        List<Budynki> listaBudynki = new ArrayList<Budynki>();
        listaBudynkiDto.forEach(param ->{
            listaBudynki.add(toEntity(param));
        });
        return listaBudynki;
    }
}
