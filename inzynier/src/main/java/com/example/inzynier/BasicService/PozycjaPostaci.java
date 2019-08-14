package com.example.inzynier.BasicService;

import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.Service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class PozycjaPostaci {
    @Autowired
    private UzytkownikService uzytkownikService;
    @Autowired
    private HttpSession sesja;
    public void savePosition(Integer x, Integer y){
        UzytkownikDTO uzytkownikDTO = uzytkownikService.findByLogin((String) sesja.getAttribute("login"));
        uzytkownikDTO.setPolozenie(x+"x"+y);
        uzytkownikService.update(uzytkownikDTO.getLogin(), uzytkownikDTO);
    }
}
