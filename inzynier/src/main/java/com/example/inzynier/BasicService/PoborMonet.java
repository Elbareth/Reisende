package com.example.inzynier.BasicService;

import com.example.inzynier.DTO.UzytkownikDTO;
import org.springframework.stereotype.Component;

@Component
public class PoborMonet {

    public UzytkownikDTO poborMonet(Integer ile, UzytkownikDTO uzytkownikDTO){
        uzytkownikDTO.setZloteMonety(uzytkownikDTO.getZloteMonety()-ile);
        if(uzytkownikDTO.getZloteMonety() <= 0){
            uzytkownikDTO.setZloteMonety(0);
        }
        return uzytkownikDTO;
    }
}
