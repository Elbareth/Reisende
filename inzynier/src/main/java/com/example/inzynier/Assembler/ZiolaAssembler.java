package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.ZiolaDTO;
import com.example.inzynier.tables.Zbroja;
import com.example.inzynier.tables.Ziola;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ZiolaAssembler {
    public ZiolaDTO toDto(Ziola ziola){
        return new ZiolaDTO(ziola.getNazwa(), ziola.getPolozenie(), ziola.getOpis(), ziola.getPlik());
    }
    public List<ZiolaDTO> toDto(List<Ziola> listaZiola){
        List<ZiolaDTO> listaZiolaDto = new ArrayList<>();
        listaZiola.forEach(param ->{
            listaZiolaDto.add(toDto(param));
        });
        return listaZiolaDto;
    }
    public Ziola toEntity(ZiolaDTO ziolaDTO){
        return new Ziola(ziolaDTO.getNazwa(), ziolaDTO.getPolozenie(), ziolaDTO.getOpis(), ziolaDTO.getPlik());
    }
    public List<Ziola> toEntity(List<ZiolaDTO> listaZiolaDto){
        List<Ziola> listaZiola = new ArrayList<>();
        listaZiolaDto.forEach(param ->{
            listaZiola.add(toEntity(param));
        });
        return listaZiola;
    }
}
