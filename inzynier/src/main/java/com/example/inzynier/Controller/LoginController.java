package com.example.inzynier.Controller;

import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.Service.UzytkownikService;
import com.example.inzynier.tables.Uzytkownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller("login")
public class LoginController {
    @Autowired
    private UzytkownikService uzytkownikService;
    @GetMapping("/index")
    public ModelAndView showMainPage(){
        return new ModelAndView("login", "uzytkownik", new UzytkownikDTO());
    }

    @PostMapping(value ="/logowanie", consumes = "multipart/form-data", produces = { "application/json", "application/xml" })
    public ModelAndView logowanie(@ModelAttribute("uzytkownik") UzytkownikDTO uzytkownikDTO, HttpSession sesja, ModelMap model, HttpServletResponse response){
        String shaszowaneHaslo = null;
        try{ // haslo hszujemy by bylo bezpieczne. W bazie sa juz shaszowane hasla
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(uzytkownikDTO.getHaslo().getBytes());
            BigInteger no = new BigInteger(1,messageDigest);
            shaszowaneHaslo = no.toString();
        }
        catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        if(uzytkownikService.isUserExist(uzytkownikDTO.getLogin(), shaszowaneHaslo)){
            sesja.setAttribute("login",uzytkownikDTO.getLogin());
            return new ModelAndView("mapa.index", "uzytkownik", new UzytkownikDTO());
        }
        else{
            try{
                PrintWriter out = response.getWriter();
                out.print("<p>\"Podany login lub haslo nie sa poprawne\"</p>");
            }
            catch(IOException e){
                e.printStackTrace();
            }
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
    }

}
