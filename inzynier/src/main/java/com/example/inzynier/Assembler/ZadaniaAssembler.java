package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.ZadaniaDTO;
import com.example.inzynier.tables.Zadania;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ZadaniaAssembler {
    @Autowired
    private PostacAssembler postacAssembler;
    public ZadaniaDTO toDto(Zadania zadania){
        return new ZadaniaDTO(zadania.getNazwa(), zadania.getTresc(), postacAssembler.toDto(zadania.getPostac()), zadania.getNagroda());
    }
    public List<ZadaniaDTO> toDto(List<Zadania> listaZadania){
        List<ZadaniaDTO> listaZadaniaDto = new ArrayList<>();
        listaZadania.forEach(param ->{
            listaZadaniaDto.add(toDto(param));
        });
        return listaZadaniaDto;
    }
    public Zadania toEntity(ZadaniaDTO zadaniaDTO){
        return new Zadania(zadaniaDTO.getNazwa(), zadaniaDTO.getTresc(), postacAssembler.toEntity(zadaniaDTO.getPostac()), zadaniaDTO.getNagroda());
    }
    public List<Zadania> toEntity(List<ZadaniaDTO> listaZadaniaDto){
        List<Zadania> listaZadania = new ArrayList<>();
        listaZadaniaDto.forEach(param ->{
            listaZadania.add(toEntity(param));
        });
        return listaZadania;
    }
}
