package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.ZbrojaDTO;
import com.example.inzynier.tables.Zbroja;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ZbrojaAssembler {
    public ZbrojaDTO toDto(Zbroja zbroja){
        return new ZbrojaDTO(zbroja.getNazwa(), zbroja.getPunktyAtaku(), zbroja.getPunktyObrony(), zbroja.getWymaganyPoziom(), zbroja.getPunktyDoswiadczenia(), zbroja.getPlik(), zbroja.getKlasa(), zbroja.getTyp());
    }
    public List<ZbrojaDTO> toDto(List<Zbroja> listaZbroja){
        List<ZbrojaDTO> listaZbrojaDto = new ArrayList<>();
        listaZbroja.forEach(param ->{
            listaZbrojaDto.add(toDto(param));
        });
        return listaZbrojaDto;
    }
    public Zbroja toEntity(ZbrojaDTO zbrojaDTO){
        return new Zbroja(zbrojaDTO.getNazwa(), zbrojaDTO.getPunktyAtaku(), zbrojaDTO.getPunktyObrony(), zbrojaDTO.getWymaganyPoziom(), zbrojaDTO.getPunktyDoswiadczenia(), zbrojaDTO.getPlik(), zbrojaDTO.getKlasa(), zbrojaDTO.getTyp());
    }
    public List<Zbroja> toEntity(List<ZbrojaDTO> listaZbrojaDto){
        List<Zbroja> listaZbroja = new ArrayList<>();
        listaZbrojaDto.forEach(param ->{
            listaZbroja.add(toEntity(param));
        });
        return listaZbroja;
    }
}
