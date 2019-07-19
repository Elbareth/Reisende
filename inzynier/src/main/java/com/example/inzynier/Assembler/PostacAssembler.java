package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.PostacDTO;
import com.example.inzynier.tables.Postac;

import java.util.ArrayList;
import java.util.List;

public class PostacAssembler {
    public PostacDTO toDto(Postac postac){
        return new PostacDTO(postac.getImie(), postac.getPolozenie(), postac.getPlik());
    }
    public List<PostacDTO> toDto(List<Postac> listaPostac){
        List<PostacDTO> listaPostacDto = new ArrayList<>();
        listaPostac.forEach(param ->{
            listaPostacDto.add(toDto(param));
        });
        return listaPostacDto;
    }
    public Postac toEntity(PostacDTO postacDTO){
        return new Postac(postacDTO.getImie(), postacDTO.getPolozenie(), postacDTO.getPlik());
    }
    public List<Postac> toEntity(List<PostacDTO> listaPostacDto){
        List<Postac> listaPostac = new ArrayList<>();
        listaPostacDto.forEach(param ->{
            listaPostac.add(toEntity(param));
        });
        return listaPostac;
    }
}
