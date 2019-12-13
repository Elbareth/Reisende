package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.PostacDTO;
import com.example.inzynier.tables.Postac;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostacAssembler {
    public PostacDTO toDto(Postac postac){
        String [] plansza = postac.getPolozenie().split("-");
        String [] tmp = plansza[1].split("x");
        return new PostacDTO(postac.getImie(), plansza[0], Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), postac.getPlik());
    }
    public List<PostacDTO> toDto(List<Postac> listaPostac){
        List<PostacDTO> listaPostacDto = new ArrayList<>();
        listaPostac.forEach(param ->{
            listaPostacDto.add(toDto(param));
        });
        return listaPostacDto;
    }
    public Postac toEntity(PostacDTO postacDTO){
        return new Postac(postacDTO.getImie(), postacDTO.getPlansza()+"-"+postacDTO.getPolozenieX()+"x"+postacDTO.getPolozenieY(), postacDTO.getPlik());
    }
    public List<Postac> toEntity(List<PostacDTO> listaPostacDto){
        List<Postac> listaPostac = new ArrayList<>();
        listaPostacDto.forEach(param ->{
            listaPostac.add(toEntity(param));
        });
        return listaPostac;
    }
}
