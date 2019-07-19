package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.WiadomosciDTO;
import com.example.inzynier.tables.Wiadomosci;

import java.util.ArrayList;
import java.util.List;

public class WiadomosciAssembler {
    public WiadomosciDTO toDto(Wiadomosci wiadomosci){
        return new WiadomosciDTO(wiadomosci.getNadawca(), wiadomosci.getOdbiorca(), wiadomosci.getTytul(),wiadomosci.getTresc(), wiadomosci.getData());
    }
    public List<WiadomosciDTO> toDto(List<Wiadomosci> listaWiadomosci){
        List<WiadomosciDTO> listaWiadomosciDto = new ArrayList<>();
        listaWiadomosci.forEach(param ->{
            listaWiadomosciDto.add(toDto(param));
        });
        return listaWiadomosciDto;
    }
    public Wiadomosci toEntity(WiadomosciDTO wiadomosciDTO){
        return new Wiadomosci(wiadomosciDTO.getNadawca(), wiadomosciDTO.getOdbiorca(), wiadomosciDTO.getTytul(),wiadomosciDTO.getTresc(), wiadomosciDTO.getData());
    }
    public List<Wiadomosci> toEntity(List<WiadomosciDTO> listaWiadomosciDto){
        List<Wiadomosci> listaWiadomosci = new ArrayList<>();
        listaWiadomosciDto.forEach(param ->{
            listaWiadomosci.add(toEntity(param));
        });
        return listaWiadomosci;
    }
    public void updateEntity(){
        //TODO
    }
}
