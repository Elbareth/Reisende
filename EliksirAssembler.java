package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.EliksirDTO;
import com.example.inzynier.tables.Eliksir;

import java.util.ArrayList;
import java.util.List;

public class EliksirAssembler {
    public EliksirDTO toDto(Eliksir eliksir){
        return new EliksirDTO(eliksir.getNazwa(), eliksir.getCena(), eliksir.getPlik(), eliksir.getWlasciwosci(), eliksir.getPrzepis());
    }
    public List<EliksirDTO> toDto(List<Eliksir> listaEliksir){
        List<EliksirDTO> listaEliksirDTO = new ArrayList<>();
        listaEliksir.forEach(param ->{
            listaEliksirDTO.add(toDto(param));
        });
        return listaEliksirDTO;
    }
    public Eliksir toEntity(EliksirDTO eliksirDTO){
        return new Eliksir(eliksirDTO.getNazwa(), eliksirDTO.getCena(), eliksirDTO.getPlik(), eliksirDTO.getWlasciwosci(), eliksirDTO.getPrzepis());
    }
    public List<Eliksir> toEntity(List<EliksirDTO> listaEliksirDto){
        List<Eliksir> listaEliksir = new ArrayList<>();
        listaEliksirDto.forEach(param ->{
            listaEliksir.add(toEntity(param));
        });
        return listaEliksir;
    }
}
