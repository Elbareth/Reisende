package com.example.inzynier.Controller;

import com.example.inzynier.DTO.Postac;
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
public class MapaController {
    @Autowired
    private UzytkownikService uzytkownikService;
    @GetMapping("/maps")
    public ModelAndView mapa(HttpSession sesja, ModelMap modelMap){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        String login = (String) sesja.getAttribute("login");
        UzytkownikDTO uzytkownikDTO = uzytkownikService.findByLogin(login);
        String [] pozycja = uzytkownikDTO.getPolozenie().split("x");
        modelMap.put("lewo",pozycja[0]);
        modelMap.put("gora",pozycja[1]);
        return new ModelAndView("mapa.index", "uzytkownik", uzytkownikDTO);
    }
    @PostMapping("/maps")
    public ModelAndView aktualizuj(HttpSession sesja, ModelMap modelMap, @RequestBody Postac postac){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        String login = (String) sesja.getAttribute("login");
        UzytkownikDTO uzytkownikDTO = uzytkownikService.findByLogin(login);
        System.out.println(postac);
        postac.setLeft(postac.getLeft().replaceAll("\\D+",""));
        postac.setTop(postac.getTop().replaceAll("\\D+",""));
        System.out.println(postac.getLeft()+"x"+postac.getTop());
        uzytkownikDTO.setPolozenie(postac.getLeft()+"x"+postac.getTop());
        uzytkownikService.update(login, uzytkownikDTO);
        modelMap.put("lewo",postac.getLeft());
        modelMap.put("gora",postac.getTop());
        return new ModelAndView("mapa.index", "uzytkownik", uzytkownikDTO);
    }
}
