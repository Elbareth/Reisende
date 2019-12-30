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
public class GraController {
    @Autowired
    private UzytkownikService uzytkownikService;
    @GetMapping("/gra")
    public ModelAndView gra(HttpSession sesja, ModelMap modelMap){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        return new ModelAndView("gra.index", "uzytkownik", uzytkownikService.findByLogin((String) sesja.getAttribute("login")));
    }
}
