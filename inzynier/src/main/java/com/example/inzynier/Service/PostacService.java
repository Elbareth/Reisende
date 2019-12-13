package com.example.inzynier.Service;

import com.example.inzynier.Assembler.PostacAssembler;
import com.example.inzynier.DTO.PostacDTO;
import com.example.inzynier.Repositories.PostacRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostacService {
    //tylko wyszukuje cala liste lub po imieniu
    //nie aktualizuje, usuwam ani tworze z poziomu kodu
    @Autowired
    private PostacRepositories postacRepositories;
    @Autowired
    private PostacAssembler postacAssembler;
    public List<PostacDTO> findAll(){
        return postacAssembler.toDto(postacRepositories.findAll());
    }
    public PostacDTO findByImie(String imie){
        if(!postacRepositories.findByImie(imie).isPresent()) throw new EntityNotFoundException("Can't find this hero");
        return postacAssembler.toDto(postacRepositories.findByImie(imie).get());
    }
    public List<PostacDTO> findByPlansza(String plansza){
        List<PostacDTO> postacList = new ArrayList<>();
        findAll().forEach( it ->{
            if(it.getPlansza().equals(plansza)){
                postacList.add(it);
            }
        });
        return postacList;
    }
    public PostacDTO findByPlik(String plik){
        if(!postacRepositories.findByPlik(plik).isPresent()) throw new EntityNotFoundException("Can't fid this hero");
        return postacAssembler.toDto(postacRepositories.findByPlik(plik).get());
    }
}
