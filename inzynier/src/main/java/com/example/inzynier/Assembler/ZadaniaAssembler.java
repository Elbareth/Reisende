package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.ZadaniaDTO;
import com.example.inzynier.Service.PostacService;
import com.example.inzynier.tables.Zadania;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ZadaniaAssembler {
    @Autowired
    private PostacAssembler postacAssembler;
    @Autowired
    private PostacService postacService;
    public ZadaniaDTO toDto(Zadania zadania){
        return new ZadaniaDTO(zadania.getNazwa(), zadania.getTresc(), zadania.getPostac().getImie(), zadania.getNagroda());
    }
    public List<ZadaniaDTO> toDto(List<Zadania> listaZadania){
        List<ZadaniaDTO> listaZadaniaDto = new ArrayList<>();
        listaZadania.forEach(param ->{
            listaZadaniaDto.add(toDto(param));
        });
        return listaZadaniaDto;
    }
    public Zadania toEntity(ZadaniaDTO zadaniaDTO){
        return new Zadania(zadaniaDTO.getNazwa(), zadaniaDTO.getTresc(), postacAssembler.toEntity(postacService.findByImie(zadaniaDTO.getPostac())), zadaniaDTO.getNagroda());
    }
    public List<Zadania> toEntity(List<ZadaniaDTO> listaZadaniaDto){
        List<Zadania> listaZadania = new ArrayList<>();
        listaZadaniaDto.forEach(param ->{
            listaZadania.add(toEntity(param));
        });
        return listaZadania;
    }
}
