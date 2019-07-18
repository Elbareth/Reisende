package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.DomekDTO;
import com.example.inzynier.tables.Domek;

public class DomekAssembler {
    public DomekDTO toDto(Domek domek){
        return new DomekDTO(domek.getWlasciciel(), String pomieszczenia, String okna, String drzwi, String lozko, String wanna, String umywalka, String toaeta, String szafki, String zlew, String kuchenka, String lodowka, String szafa, String obraz, String dywany, String kominki, String kwiaty, String wazony, String trofea, String kojec, String krzesla, String fotele, String sofa, String stoly, String barek, String podloga);
    }
    public List<DialogPostaciDTO> toDto(List<DialogPostaci> listaDialoguPostaci){
        List<DialogPostaciDTO> listaDialogPostaciDTO = new ArrayList<>();
        listaDialoguPostaci.forEach(param ->{
            listaDialogPostaciDTO.add(toDto(param));
        });
        return listaDialogPostaciDTO;
    }
    public DialogPostaci toEntity(DialogPostaciDTO dialogPostaciDto){
        return new DialogPostaci(dialogPostaciDto.getNazwaQuesta(), dialogPostaciDto.getPostac(), dialogPostaciDto.getTekst());
    }
    public List<DialogPostaci> toEntity(List<DialogPostaciDTO> listaDialoguPostaciDto){
        List<DialogPostaci> listaDialogPostaci = new ArrayList<>();
        listaDialoguPostaciDto.forEach(param ->{
            listaDialogPostaci.add(toEntity(param));
        });
        return listaDialogPostaci;
    }
}
