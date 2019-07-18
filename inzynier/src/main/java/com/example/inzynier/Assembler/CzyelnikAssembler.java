package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.CzytelnikDTO;
import com.example.inzynier.tables.Czytelnik;

import java.util.ArrayList;
import java.util.List;

public class CzyelnikAssembler {
    public CzytelnikDTO toDto(Czytelnik czytelnik){
        return new CzytelnikDTO(czytelnik.getTytul(), czytelnik.getCzytelnik());
    }
    public List<CzytelnikDTO> toDto(List<Czytelnik> listaCzytelnik){
        List<CzytelnikDTO> listaCzytelnikDto = new ArrayList<>();
        listaCzytelnik.forEach(param ->{
            listaCzytelnikDto.add(toDto(param));
        });
        return listaCzytelnikDto;
    }
    public Czytelnik toEntity(CzytelnikDTO czytelnikDTO){
        return new Czytelnik(czytelnikDTO.getTytul(), czytelnikDTO.getCzytelnik());
    }
    public List<Czytelnik> toEntity(List<CzytelnikDTO> listaCzytelnikDto){
        List<Czytelnik> listaCzytelnik = new ArrayList<>();
        listaCzytelnikDto.forEach(param ->{
            listaCzytelnik.add(toEntity(param));
        });
        return listaCzytelnik;
    }
    public void updateEntity(){
        //TODO napisz update gdy zmienisz relacje
    }
}
