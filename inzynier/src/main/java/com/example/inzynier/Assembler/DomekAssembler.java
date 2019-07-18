package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.DomekDTO;
import com.example.inzynier.tables.Domek;

import java.util.ArrayList;
import java.util.List;

public class DomekAssembler {
    public DomekDTO toDto(Domek domek){
        return new DomekDTO(domek.getWlasciciel(), domek.getPomieszczenia(), domek.getOkna(), domek.getDrzwi(), domek.getLozko(), domek.getWanna(), domek.getUmywalka(), domek.getToaeta(), domek.getSzafki(), domek.getZlew(), domek.getKuchenka(), domek.getLodowka(), domek.getSzafa(), domek.getObraz(), domek.getDywany(), domek.getKominki(), domek.getKwiaty(), domek.getWazony(), domek.getTrofea(), domek.getKojec(), domek.getKrzesla(), domek.getFotele(), domek.getSofa(), domek.getStoly(), domek.getBarek(), domek.getPodloga());
    }
    public List<DomekDTO> toDto(List<Domek> listaDomek){
        List<DomekDTO> listaDomekDTO = new ArrayList<>();
        listaDomek.forEach(param ->{
            listaDomekDTO.add(toDto(param));
        });
        return listaDomekDTO;
    }
    public Domek toEntity(DomekDTO domekDto){
        return new Domek(domekDto.getWlasciciel(), domekDto.getPomieszczenia(), domekDto.getOkna(), domekDto.getDrzwi(), domekDto.getLozko(), domekDto.getWanna(), domekDto.getUmywalka(), domekDto.getToaeta(), domekDto.getSzafki(), domekDto.getZlew(), domekDto.getKuchenka(), domekDto.getLodowka(), domekDto.getSzafa(), domekDto.getObraz(), domekDto.getDywany(), domekDto.getKominki(), domekDto.getKwiaty(), domekDto.getWazony(), domekDto.getTrofea(), domekDto.getKojec(), domekDto.getKrzesla(), domekDto.getFotele(), domekDto.getSofa(), domekDto.getStoly(), domekDto.getBarek(), domekDto.getPodloga());
    }
    public List<Domek> toEntity(List<DomekDTO> listaDomekDto){
        List<Domek> listaDomek = new ArrayList<>();
        listaDomekDto.forEach(param ->{
            listaDomek.add(toEntity(param));
        });
        return listaDomek;
    }
    public void updateEntity(){
        //TODO 
    }
}
