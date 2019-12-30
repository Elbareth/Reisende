package com.example.inzynier.Controller;

import com.example.inzynier.DTO.CzytanieDTO;
import com.example.inzynier.DTO.KsiazkiDTO;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.Service.KsiazkiService;
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
public class KsiazkaController {
    @Autowired
    private UzytkownikService uzytkownikService;
    @Autowired
    private KsiazkiService ksiazkiService;
    @GetMapping("/ksiazka")
    public ModelAndView getKsiazka(HttpSession sesja, ModelMap modelMap){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        modelMap.put("ksiazki", ksiazkiService.findAll());
        return new ModelAndView("ksiazka.index", "uzytkownik", uzytkownikService.findByLogin((String) sesja.getAttribute("login")));
    }
    @PostMapping("/ksiazka")
    public ModelAndView przeczytane(@RequestBody CzytanieDTO czytanieDTO, HttpSession sesja, ModelMap modelMap){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        KsiazkiDTO ksiazkiDTO = ksiazkiService.findById(Integer.parseInt(czytanieDTO.getKsiazka()));
        UzytkownikDTO uzytkownikDTO = uzytkownikService.findByLogin((String) sesja.getAttribute("login"));
        uzytkownikDTO.setDoswiadczenie(uzytkownikDTO.getDoswiadczenie() + ksiazkiDTO.getDoswiadczenia());
        uzytkownikService.update(uzytkownikDTO.getLogin(), uzytkownikDTO);
        return getKsiazka(sesja, modelMap);
    }
}
