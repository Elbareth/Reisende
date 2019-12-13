package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.DialogPostaciDTO;
import com.example.inzynier.Service.PostacService;
import com.example.inzynier.tables.DialogPostaci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DialogPostaciAssembler {
    @Autowired
    private PostacAssembler postacAssembler;
    @Autowired
    private PostacService postacService;
    public DialogPostaciDTO toDto(DialogPostaci dialogPostaci){
        return new DialogPostaciDTO(dialogPostaci.getNazwaQuesta(), dialogPostaci.getPostac().getImie(), dialogPostaci.getTekst());
    }
    public List<DialogPostaciDTO> toDto(List<DialogPostaci> listaDialoguPostaci){
        List<DialogPostaciDTO> listaDialogPostaciDTO = new ArrayList<>();
        listaDialoguPostaci.forEach(param ->{
            listaDialogPostaciDTO.add(toDto(param));
        });
        return listaDialogPostaciDTO;
    }
    public DialogPostaciDTO toDtoWithId(DialogPostaci dialogPostaci){
        return new DialogPostaciDTO(dialogPostaci.getId(), dialogPostaci.getNazwaQuesta(), dialogPostaci.getPostac().getImie(), dialogPostaci.getTekst());
    }
    public List<DialogPostaciDTO> toDtoWithId(List<DialogPostaci> listaDialoguPostaci){
        List<DialogPostaciDTO> listaDialogPostaciDTO = new ArrayList<>();
        listaDialoguPostaci.forEach(param ->{
            listaDialogPostaciDTO.add(toDtoWithId(param));
        });
        return listaDialogPostaciDTO;
    }
    public DialogPostaci toEntity(DialogPostaciDTO dialogPostaciDto){
        return new DialogPostaci(dialogPostaciDto.getNazwaQuesta(), postacAssembler.toEntity(postacService.findByImie(dialogPostaciDto.getPostac())), dialogPostaciDto.getTekst());
    }
    public List<DialogPostaci> toEntity(List<DialogPostaciDTO> listaDialoguPostaciDto){
        List<DialogPostaci> listaDialogPostaci = new ArrayList<>();
        listaDialoguPostaciDto.forEach(param ->{
            listaDialogPostaci.add(toEntity(param));
        });
        return listaDialogPostaci;
    }
}
