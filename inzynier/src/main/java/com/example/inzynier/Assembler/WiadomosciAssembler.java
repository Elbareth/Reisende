package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.WiadomosciDTO;
import com.example.inzynier.Service.UzytkownikService;
import com.example.inzynier.tables.Wiadomosci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WiadomosciAssembler {
    @Autowired
    private UzytkownikService uzytkownikService;
    @Autowired
    private UzytkownikAssembler uzytkownikAssembler;
    public WiadomosciDTO toDto(Wiadomosci wiadomosci){
        return new WiadomosciDTO(wiadomosci.getNadawca().getLogin(),
                wiadomosci.getOdbiorca().getLogin(),
                wiadomosci.getTytul(),
                wiadomosci.getTresc(),
                wiadomosci.getData());
    }

    public List<WiadomosciDTO> toDto(List<Wiadomosci> listaWiadomosci){
        List<WiadomosciDTO> listaWiadomosciDto = new ArrayList<>();
        listaWiadomosci.forEach(param ->{
            listaWiadomosciDto.add(toDto(param));
        });
        return listaWiadomosciDto;
    }

    public WiadomosciDTO toDtoWithId(Wiadomosci wiadomosci){
        return new WiadomosciDTO(wiadomosci.getId(),
                wiadomosci.getNadawca().getLogin(),
                wiadomosci.getOdbiorca().getLogin(),
                wiadomosci.getTytul(),
                wiadomosci.getTresc(),
                wiadomosci.getData());
    }

    public List<WiadomosciDTO> toDtoWithId(List<Wiadomosci> listaWiadomosci){
        List<WiadomosciDTO> listaWiadomosciDto = new ArrayList<>();
        listaWiadomosci.forEach(param ->{
            listaWiadomosciDto.add(toDtoWithId(param));
        });
        return listaWiadomosciDto;
    }

    public Wiadomosci toEntity(WiadomosciDTO wiadomosciDTO){
        return new Wiadomosci(
                uzytkownikAssembler.toEntity(uzytkownikService.findByLogin(wiadomosciDTO.getNadawca())),
                uzytkownikAssembler.toEntity(uzytkownikService.findByLogin(wiadomosciDTO.getOdbiorca())),
                wiadomosciDTO.getTytul(),
                wiadomosciDTO.getTresc(),
                wiadomosciDTO.getData());
    }

    public List<Wiadomosci> toEntity(List<WiadomosciDTO> listaWiadomosciDto){
        List<Wiadomosci> listaWiadomosci = new ArrayList<>();
        listaWiadomosciDto.forEach(param ->{
            listaWiadomosci.add(toEntity(param));
        });
        return listaWiadomosci;
    }
}
