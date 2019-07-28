package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.DialogPostaciDTO;
import com.example.inzynier.tables.DialogPostaci;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class DialogPostaciAssembler {
    @Autowired
    private PostacAssembler postacAssembler;
    public DialogPostaciDTO toDto(DialogPostaci dialogPostaci){
        return new DialogPostaciDTO(dialogPostaci.getNazwaQuesta(), postacAssembler.toDto(dialogPostaci.getPostac()), dialogPostaci.getTekst());
    }
    public List<DialogPostaciDTO> toDto(List<DialogPostaci> listaDialoguPostaci){
        List<DialogPostaciDTO> listaDialogPostaciDTO = new ArrayList<>();
        listaDialoguPostaci.forEach(param ->{
            listaDialogPostaciDTO.add(toDto(param));
        });
        return listaDialogPostaciDTO;
    }
    public DialogPostaci toEntity(DialogPostaciDTO dialogPostaciDto){
        return new DialogPostaci(dialogPostaciDto.getNazwaQuesta(), postacAssembler.toEntity(dialogPostaciDto.getPostac()), dialogPostaciDto.getTekst());
    }
    public List<DialogPostaci> toEntity(List<DialogPostaciDTO> listaDialoguPostaciDto){
        List<DialogPostaci> listaDialogPostaci = new ArrayList<>();
        listaDialoguPostaciDto.forEach(param ->{
            listaDialogPostaci.add(toEntity(param));
        });
        return listaDialogPostaci;
    }
}
