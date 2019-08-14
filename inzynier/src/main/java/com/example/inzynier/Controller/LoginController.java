package com.example.inzynier.Controller;

import com.example.inzynier.BasicService.HashPassword;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.Service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UzytkownikService uzytkownikService;
    private HashPassword hash = new HashPassword();
    @GetMapping("/home")
    public ModelAndView showMainPage(){
        return new ModelAndView("login", "uzytkownik", new UzytkownikDTO());
    }

    @PostMapping(value ="/logowanie", consumes = "multipart/form-data", produces = { "application/json", "application/xml" })
    public ModelAndView logowanie(@ModelAttribute("uzytkownik") UzytkownikDTO uzytkownikDTO, HttpSession sesja, ModelMap model, HttpServletResponse response){
        String shaszowaneHaslo = null;
        shaszowaneHaslo = hash.hashMyPassword(uzytkownikDTO.getHaslo(), shaszowaneHaslo);
        if(uzytkownikService.isUserExist(uzytkownikDTO.getLogin(), shaszowaneHaslo)){
            sesja.setAttribute("login",uzytkownikDTO.getLogin());
            model.put("uzytkownik",new UzytkownikDTO());
            return new ModelAndView("redirect:/maps", model);
        }
        else{
            //TODO Alert
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
    }

}
