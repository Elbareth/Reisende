package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.InnePrzedmiotyDTO;
import com.example.inzynier.tables.InnePrzedmioty;

import java.util.ArrayList;
import java.util.List;

public class InnePrzedmiotyAssembler {
    public InnePrzedmiotyDTO toDto(InnePrzedmioty innePrzedmioty){
        return new InnePrzedmiotyDTO(innePrzedmioty.getNazwa(), innePrzedmioty.getCena(), innePrzedmioty.getPlik(), innePrzedmioty.getOpis());
    }
    public List<InnePrzedmiotyDTO> toDto(List<InnePrzedmioty> listaInnePrzedmioty){
        List<InnePrzedmiotyDTO> listaInnePrzedmiotyDTO = new ArrayList<>();
        listaInnePrzedmioty.forEach(param ->{
            listaInnePrzedmiotyDTO.add(toDto(param));
        });
        return listaInnePrzedmiotyDTO;
    }
    public InnePrzedmioty toEntity(InnePrzedmiotyDTO innePrzedmiotyDTO){
        return new InnePrzedmioty(innePrzedmiotyDTO.getNazwa(), innePrzedmiotyDTO.getCena(), innePrzedmiotyDTO.getPlik(), innePrzedmiotyDTO.getOpis());
    }
    public List<InnePrzedmioty> toEntity(List<InnePrzedmiotyDTO> listaInnePrzedmiotyDto){
        List<InnePrzedmioty> listaInnePrzedmioty = new ArrayList<>();
        listaInnePrzedmiotyDto.forEach(param ->{
            listaInnePrzedmioty.add(toEntity(param));
        });
        return listaInnePrzedmioty;
    }
}
