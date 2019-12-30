package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.BestieDTO;
import com.example.inzynier.tables.Bestie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BestieAssembler {
    public BestieDTO toDto(Bestie bestie){
        List<String> plansza = new ArrayList<>();
        List<Integer> polozenieX = new ArrayList<>();
        List<Integer> polozenieY = new ArrayList<>();
        String [] tmp = bestie.getPolozenie().split(";");
        for(int i=0;i<tmp.length;i++){
            String [] pl = tmp[i].split("-");
            String [] pol = pl[1].split("x");
            plansza.add(pl[0]);
            polozenieX.add(Integer.parseInt(pol[0]));
            polozenieY.add(Integer.parseInt(pol[1]));
        }
        return new BestieDTO(bestie.getNazwa(), bestie.getPlik(), plansza, polozenieX, polozenieY, bestie.getSila());
    }
    public List<BestieDTO> toDto(List<Bestie> listaBestii){
        List<BestieDTO> listaBestieDto = new ArrayList<BestieDTO>();
        listaBestii.forEach(param ->{
               listaBestieDto.add(toDto(param));
        });
        return listaBestieDto;
    }
    public BestieDTO toDtoWithId(Bestie bestie){
        List<String> plansza = new ArrayList<>();
        List<Integer> polozenieX = new ArrayList<>();
        List<Integer> polozenieY = new ArrayList<>();
        String [] tmp = bestie.getPolozenie().split(";");
        for(int i=0;i<tmp.length;i++){
            String [] pl = tmp[i].split("-");
            String [] pol = pl[1].split("x");
            plansza.add(pl[0]);
            polozenieX.add(Integer.parseInt(pol[0]));
            polozenieY.add(Integer.parseInt(pol[1]));
        }
        return new BestieDTO(bestie.getId(), bestie.getNazwa(), bestie.getPlik(), plansza, polozenieX, polozenieY, bestie.getSila());
    }
    public List<BestieDTO> toDtoWithId(List<Bestie> listaBestii){
        List<BestieDTO> listaBestieDto = new ArrayList<BestieDTO>();
        listaBestii.forEach(param ->{
            listaBestieDto.add(toDtoWithId(param));
        });
        return listaBestieDto;
    }
    public Bestie toEntity(BestieDTO bestieDTO){
        String polozenie = "";
        for(int i=0;i<bestieDTO.getPlansza().size();i++){
            polozenie = polozenie +
                    bestieDTO.getPlansza().get(i)+
                    "-"+
                    bestieDTO.getPolozenieX().get(i)+
                    "x"+
                    bestieDTO.getPolozenieY().get(i)+
                    ";";
        }
        return new Bestie(bestieDTO.getNazwa(), bestieDTO.getPlik(), polozenie, bestieDTO.getSila());
    }
    public List<Bestie> toEntity(List<BestieDTO> listaBestiiDTO){
        List<Bestie> listaBestie = new ArrayList<>();
        listaBestiiDTO.forEach(param ->{
            listaBestie.add(toEntity(param));
        });
        return listaBestie;
    }
}
