package com.example.inzynier.Service;

import com.example.inzynier.Assembler.DialogPostaciAssembler;
import com.example.inzynier.DTO.DialogPostaciDTO;
import com.example.inzynier.Repositories.DialogPostaciRepositories;
import com.example.inzynier.Repositories.PostacRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DialogPostaciService {
    //nie mam potrzeby modyfikacji dodawania i usuwania z poziomu kodu
    //potrzebuje jedynie wyszukiwanie po id, postaci i nazwie questa
    @Autowired
    private DialogPostaciRepositories dialogPostaciRepositories;
    @Autowired
    private DialogPostaciAssembler dialogPostaciAssembler;
    @Autowired
    private PostacRepositories postacRepositories;

    public List<DialogPostaciDTO> findByNazwaQuesta(String nazwaQuesta){
        return dialogPostaciAssembler.toDtoWithId(dialogPostaciRepositories.findByNazwaQuesta(nazwaQuesta));
    }
    public List<DialogPostaciDTO> findByPostac(String postac){
        if(!postacRepositories.findByImie(postac).isPresent()) throw new EntityNotFoundException("Can't find this hero");
        return dialogPostaciAssembler.toDtoWithId(dialogPostaciRepositories.findByPostac(postacRepositories.findByImie(postac).get()));
    }
    public DialogPostaciDTO findById(Integer id){
        if(!dialogPostaciRepositories.findById(id).isPresent()) throw new EntityNotFoundException("Can't find this quest");
        return dialogPostaciAssembler.toDtoWithId(dialogPostaciRepositories.findById(id).get());
    }
    public DialogPostaciDTO findByIdAndNazwaQuestaAndTekst(Integer id, String nazwaQuesta, String tekst){
        return dialogPostaciAssembler.toDtoWithId(dialogPostaciRepositories.findByIdAndNazwaQuestaAndTekst(id, nazwaQuesta, tekst).get());
    }
    public DialogPostaciDTO findByTekst(String tekst){
        return dialogPostaciAssembler.toDtoWithId(dialogPostaciRepositories.findByTekst(tekst).get());
    }
    public List<DialogPostaciDTO> findByNazwaQuestaAndPostac(String nazwaQuesta, String postac){
        return dialogPostaciAssembler.toDtoWithId(dialogPostaciRepositories.findByNazwaQuestaAndPostac(nazwaQuesta, postacRepositories.findByImie(postac).get()));
    }
}
