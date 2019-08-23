package com.example.inzynier.Controller;

import com.example.inzynier.DTO.DomekDTO;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.DTO.WymiaryDTO;
import com.example.inzynier.Service.DomekService;
import com.example.inzynier.Service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class DomekController {
    @Autowired
    private DomekService domekService;
    @Autowired
    private UzytkownikService uzytkownikService;
    @GetMapping("/dom")
    public ModelAndView getDomek(HttpSession sesja, ModelMap model){
        if(sesja.getAttribute("login") == null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        DomekDTO domek = domekService.findByWlasciciel((String) sesja.getAttribute("login"));
        model.put("uzytkownik", uzytkownikService.findByLogin((String) sesja.getAttribute("login")));
        String [] pomieszczenia = domek.getPomieszczenia().split("x");
        model.put("pomieszczenia", new WymiaryDTO(Integer.parseInt(pomieszczenia[0]),Integer.parseInt(pomieszczenia[1])));
        return new ModelAndView("dom.index", "domek", domek);
    }
}
