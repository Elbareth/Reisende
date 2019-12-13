package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.WygladPostaciDTO;
import com.example.inzynier.tables.WygladPostaci;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WygladPostaciAssembler {
    public WygladPostaciDTO toDto(WygladPostaci wygladPostaci){
        return new WygladPostaciDTO(wygladPostaci.getNazwa(), wygladPostaci.getKlasa(), wygladPostaci.getPlik(), wygladPostaci.getKategoria());
    }
    public List<WygladPostaciDTO> toDto(List<WygladPostaci> listaWygladPostaci){
        List<WygladPostaciDTO> listaWygladPostaciDto = new ArrayList<>();
        listaWygladPostaci.forEach(param ->{
            listaWygladPostaciDto.add(toDto(param));
        });
        return listaWygladPostaciDto;
    }
    public WygladPostaciDTO toDtoWithId(WygladPostaci wygladPostaci){
        return new WygladPostaciDTO(wygladPostaci.getId(), wygladPostaci.getNazwa(), wygladPostaci.getKlasa(), wygladPostaci.getPlik(), wygladPostaci.getKategoria());
    }
    public List<WygladPostaciDTO> toDtoWithId(List<WygladPostaci> listaWygladPostaci){
        List<WygladPostaciDTO> listaWygladPostaciDto = new ArrayList<>();
        listaWygladPostaci.forEach(param ->{
            listaWygladPostaciDto.add(toDtoWithId(param));
        });
        return listaWygladPostaciDto;
    }
    public WygladPostaci toEntity(WygladPostaciDTO wygladPostaciDTO){
        return new WygladPostaci(wygladPostaciDTO.getNazwa(), wygladPostaciDTO.getKlasa(), wygladPostaciDTO.getPlik(), wygladPostaciDTO.getKategoria());
    }
    public List<WygladPostaci> toEntity(List<WygladPostaciDTO> listaWygladPostaciDto){
        List<WygladPostaci> listaWygladPostaci = new ArrayList<>();
        listaWygladPostaciDto.forEach(param ->{
            listaWygladPostaci.add(toEntity(param));
        });
        return listaWygladPostaci;
    }
}
