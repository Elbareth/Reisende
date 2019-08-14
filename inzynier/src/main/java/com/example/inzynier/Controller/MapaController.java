package com.example.inzynier.Controller;

import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.Service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
}
