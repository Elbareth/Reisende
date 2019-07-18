package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.KsiazkiDTO;
import com.example.inzynier.tables.Ksiazki;

import java.util.ArrayList;
import java.util.List;

public class KsiazkiAssembler {
    public KsiazkiDTO toDto(Ksiazki ksiazki){
        return new KsiazkiDTO(ksiazki.getNazwa(), ksiazki.getTresc(), ksiazki.getDoswiadczenia());
    }
    public List<KsiazkiDTO> toDto(List<Ksiazki> listaKsiazki){
        List<KsiazkiDTO> listaKsiazkiDTO = new ArrayList<>();
        listaKsiazki.forEach(param ->{
            listaKsiazkiDTO.add(toDto(param));
        });
        return listaKsiazkiDTO;
    }
    public Ksiazki toEntity(KsiazkiDTO ksiazkiDTO){
        return new Ksiazki(ksiazkiDTO.getNazwa(), ksiazkiDTO.getTresc(), ksiazkiDTO.getDoswiadczenia());
    }
    public List<Ksiazki> toEntity(List<KsiazkiDTO> listaKsiazkiDto){
        List<Ksiazki> listaKsiazki = new ArrayList<>();
        listaKsiazkiDto.forEach(param ->{
            listaKsiazki.add(toEntity(param));
        });
        return listaKsiazki;
    }
}
