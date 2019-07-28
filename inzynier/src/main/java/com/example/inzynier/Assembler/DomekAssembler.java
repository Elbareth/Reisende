package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.DomekDTO;
import com.example.inzynier.Service.UzytkownikService;
import com.example.inzynier.tables.Domek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DomekAssembler {
    @Autowired
    private UzytkownikService uzytkownikService;
    @Autowired
    private UzytkownikAssembler uzytkownikAssembler;
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
        return new Domek(domekDto.getWlasciciel(),uzytkownikAssembler.toEntity(uzytkownikService.findByLogin(domekDto.getWlasciciel())), domekDto.getPomieszczenia(), domekDto.getOkna(), domekDto.getDrzwi(), domekDto.getLozko(), domekDto.getWanna(), domekDto.getUmywalka(), domekDto.getToaeta(), domekDto.getSzafki(), domekDto.getZlew(), domekDto.getKuchenka(), domekDto.getLodowka(), domekDto.getSzafa(), domekDto.getObraz(), domekDto.getDywany(), domekDto.getKominki(), domekDto.getKwiaty(), domekDto.getWazony(), domekDto.getTrofea(), domekDto.getKojec(), domekDto.getKrzesla(), domekDto.getFotele(), domekDto.getSofa(), domekDto.getStoly(), domekDto.getBarek(), domekDto.getPodloga());
    }
    public List<Domek> toEntity(List<DomekDTO> listaDomekDto){
        List<Domek> listaDomek = new ArrayList<>();
        listaDomekDto.forEach(param ->{
            listaDomek.add(toEntity(param));
        });
        return listaDomek;
    }
    public void updateEntity(Domek domek, DomekDTO domekDTO){
        domek.setPomieszczenia(domekDTO.getPomieszczenia());
        domek.setOkna(domekDTO.getOkna());
        domek.setDrzwi(domekDTO.getDrzwi());
        domek.setLozko(domekDTO.getLozko());
        domek.setWanna(domekDTO.getWanna());
        domek.setUmywalka(domekDTO.getUmywalka());
        domek.setToaeta(domekDTO.getToaeta());
        domek.setSzafki(domekDTO.getSzafki());
        domek.setZlew(domekDTO.getZlew());
        domek.setKuchenka(domekDTO.getKuchenka());
        domek.setLodowka(domekDTO.getLodowka());
        domek.setSzafa(domekDTO.getSzafa());
        domek.setObraz(domekDTO.getObraz());
        domek.setDywany(domekDTO.getDywany());
        domek.setKominki(domekDTO.getKominki());
        domek.setKwiaty(domekDTO.getKwiaty());
        domek.setWazony(domekDTO.getWazony());
        domek.setTrofea(domekDTO.getTrofea());
        domek.setKojec(domekDTO.getKojec());
        domek.setKrzesla(domekDTO.getKrzesla());
        domek.setFotele(domekDTO.getFotele());
        domek.setSofa(domekDTO.getSofa());
        domek.setStoly(domekDTO.getStoly());
        domek.setBarek(domekDTO.getBarek());
        domek.setPodloga(domekDTO.getPodloga());
    }
}
