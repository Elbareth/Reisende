package com.example.inzynier.Controller;

import com.example.inzynier.DTO.SurowceDTO;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.Service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class TargController {

    @Autowired
    private UzytkownikService uzytkownikService;

    @GetMapping("/targ")
    public ModelAndView targ(HttpSession sesja, ModelMap modelMap){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        return new ModelAndView("targ.index","uzytkownik", uzytkownikService.findByLogin((String) sesja.getAttribute("login")));
    }
    @PostMapping("targ")
    public ModelAndView sprzedaj(@RequestBody SurowceDTO surowceDTO, HttpSession sesja, ModelMap modelMap){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        System.out.println(surowceDTO);
        UzytkownikDTO uzytkownikDTO = uzytkownikService.findByLogin((String) sesja.getAttribute("login"));
        uzytkownikDTO.setDrewno(uzytkownikDTO.getDrewno() - Integer.parseInt(surowceDTO.getDrewno()));
        uzytkownikDTO.setGrudkaGliny(uzytkownikDTO.getGrudkaGliny() - Integer.parseInt(surowceDTO.getGlina()));
        uzytkownikDTO.setGrudkaZelaza(uzytkownikDTO.getGrudkaZelaza() - Integer.parseInt(surowceDTO.getZelazo()));
        uzytkownikDTO.setWorekZboza(uzytkownikDTO.getWorekZboza() - Integer.parseInt(surowceDTO.getZboze()));
        uzytkownikDTO.setDeski(uzytkownikDTO.getDeski() - Integer.parseInt(surowceDTO.getDeski()));
        uzytkownikDTO.setCegly(uzytkownikDTO.getCegly() - Integer.parseInt(surowceDTO.getCegla()));
        uzytkownikDTO.setSztabkaZelaza(uzytkownikDTO.getSztabkaZelaza() - Integer.parseInt(surowceDTO.getSztabkaZelaza()));
        uzytkownikDTO.setChleb(uzytkownikDTO.getChleb() - Integer.parseInt(surowceDTO.getChleb()));
        uzytkownikDTO.setZloteMonety(
                uzytkownikDTO.getZloteMonety()+
                Integer.parseInt(surowceDTO.getDrewno())+
                Integer.parseInt(surowceDTO.getGlina())+
                Integer.parseInt(surowceDTO.getZelazo())+
                Integer.parseInt(surowceDTO.getZboze())+
                (Integer.parseInt(surowceDTO.getDeski()) * 2 )+
                (Integer.parseInt(surowceDTO.getGlina())  * 2 )+
                (Integer.parseInt(surowceDTO.getSztabkaZelaza()) * 2 )+
                (Integer.parseInt(surowceDTO.getChleb()) * 2)
        );
        uzytkownikService.update(uzytkownikDTO.getLogin(), uzytkownikDTO);
        return targ(sesja, modelMap);
    }
}
