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
        List<String> plansze = new ArrayList<>();
        List<Integer> pozycjeX = new ArrayList<>();
        List<Integer> pozycjeY = new ArrayList<>();
        String [] liczba = ziola.getPolozenie().split(";");
        for(int i=0;i<liczba.length;i++){
            String [] plansza = liczba[i].split("-");
            plansze.add(plansza[0]);
            String [] tmp = plansza[1].split("x");
            pozycjeX.add(Integer.parseInt(tmp[0]));
            pozycjeY.add(Integer.parseInt(tmp[1]));
        }
        return new ZiolaDTO(ziola.getNazwa(), plansze, pozycjeX, pozycjeY, ziola.getOpis(), ziola.getPlik());
    }
    public List<ZiolaDTO> toDto(List<Ziola> listaZiola){
        List<ZiolaDTO> listaZiolaDto = new ArrayList<>();
        listaZiola.forEach(param ->{
            listaZiolaDto.add(toDto(param));
        });
        return listaZiolaDto;
    }
    public Ziola toEntity(ZiolaDTO ziolaDTO){
        String polozenie = "";
        for(int i=0;i<ziolaDTO.getPlansza().size();i++){
            polozenie = polozenie +
                    ziolaDTO.getPlansza().get(i)+
                    "-"+
                    ziolaDTO.getPolozenieX().get(i)+
                    "x"+
                    ziolaDTO.getPolozenieY().get(i)+
                    ";";
        }
        return new Ziola(ziolaDTO.getNazwa(), polozenie, ziolaDTO.getOpis(), ziolaDTO.getPlik());
    }
    public List<Ziola> toEntity(List<ZiolaDTO> listaZiolaDto){
        List<Ziola> listaZiola = new ArrayList<>();
        listaZiolaDto.forEach(param ->{
            listaZiola.add(toEntity(param));
        });
        return listaZiola;
    }
}
