package com.example.inzynier.Controller;

import com.example.inzynier.BasicService.HashPassword;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.Service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController{
    @Autowired
    private UzytkownikService uzytkownikService;
    private HashPassword hash = new HashPassword();
    @RequestMapping(value = "/home", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView showMainPage(){
        return new ModelAndView("login", "uzytkownik", new UzytkownikDTO());
    }

    @PostMapping(value ="/logowanie", consumes = "multipart/form-data", produces = { "application/json", "application/xml" })
    public ModelAndView logowanie(@ModelAttribute("uzytkownik") UzytkownikDTO uzytkownikDTO, HttpSession sesja, ModelMap model, HttpServletResponse response , HttpServletRequest request){
        String shaszowaneHaslo = null;
        shaszowaneHaslo = hash.hashMyPassword(uzytkownikDTO.getHaslo(), shaszowaneHaslo);
        if(uzytkownikService.isUserExist(uzytkownikDTO.getLogin(), shaszowaneHaslo)){
            sesja.setAttribute("login",uzytkownikDTO.getLogin());
            model.put("uzytkownik",new UzytkownikDTO());
            return new ModelAndView("redirect:/maps", model);
        }
        else{
            model.put("error","Podany login lub hasla sa bledne");
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
    }

}
