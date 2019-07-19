package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.SmokDTO;
import com.example.inzynier.tables.Smok;

import java.util.ArrayList;
import java.util.List;

public class SmokAssembler {
    public SmokDTO toDto(Smok smok){
        return new SmokDTO(smok.getWlasciciel(), smok.getImie(), smok.getGatunek(), smok.getPunktyZycia(), smok.getPlik());
    }
    public List<SmokDTO> toDto(List<Smok> listaSmok){
        List<SmokDTO> listaSmokDto = new ArrayList<>();
        listaSmok.forEach(param ->{
            listaSmokDto.add(toDto(param));
        });
        return listaSmokDto;
    }
    public Smok toEntity(SmokDTO smokDTO){
        return new Smok(smokDTO.getWlasciciel(), smokDTO.getImie(), smokDTO.getGatunek(), smokDTO.getPunktyZycia(), smokDTO.getPlik());
    }
    public List<Smok> toEntity(List<SmokDTO> listaSmokDto){
        List<Smok> listaSmok = new ArrayList<>();
        listaSmokDto.forEach(param ->{
            listaSmok.add(toEntity(param));
        });
        return listaSmok;
    }
    public void updateEntity(){
        //TODO
    }
}
