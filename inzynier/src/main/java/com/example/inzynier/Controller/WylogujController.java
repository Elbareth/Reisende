package com.example.inzynier.Controller;

import com.example.inzynier.DTO.UzytkownikDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class WylogujController {
    @GetMapping("/wyloguj")
    public ModelAndView wyloguj(HttpSession sesja){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        sesja.invalidate();
        return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
    }
}
