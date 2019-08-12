package com.example.inzynier.Controller;

import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.DTO.UzytkownikRejestracjaDTO;
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
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
public class RejestracjaController {
    @Autowired
    private UzytkownikService uzytkownikService;
    @GetMapping("/zarejestruj")
    public ModelAndView zarejestruj(){
        return new ModelAndView("/rejestracja", "uzytkownik", new UzytkownikRejestracjaDTO());
    }
    @PostMapping(value = "/register", consumes = "multipart/form-data", produces = { "application/json", "application/xml" })
    public ModelAndView register(@ModelAttribute("uzytkownik") UzytkownikRejestracjaDTO uzytkownikRejestracjaDTO, HttpSession sesja, ModelMap model, HttpServletResponse response){
        UzytkownikDTO user;
        if(uzytkownikService.isThisLoginInUse(uzytkownikRejestracjaDTO.getLogin())){
            try{
                PrintWriter out = response.getWriter();
                out.print("<p>\"Podany login lub haslo nie sa poprawne\" </p>");
            }
            catch(IOException e){
                e.printStackTrace();
            }
            return new ModelAndView("rejestracja","uzytkownik",new UzytkownikRejestracjaDTO());
        }
        else{
            String shaszowaneHaslo = null;
            try{ // haslo hszujemy by bylo bezpieczne. W bazie sa juz shaszowane hasla
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] messageDigest = md.digest(uzytkownikRejestracjaDTO.getHaslo().getBytes());
                BigInteger no = new BigInteger(1,messageDigest);
                shaszowaneHaslo = no.toString();
            }
            catch(NoSuchAlgorithmException e){
                e.printStackTrace();
            }
             user = new UzytkownikDTO(uzytkownikRejestracjaDTO.getLogin(), shaszowaneHaslo, uzytkownikRejestracjaDTO.getNick(),
                    uzytkownikRejestracjaDTO.getKlasaPostaci(), 100, 0, "Szatyn Wojownik", uzytkownikRejestracjaDTO.getPlec(), 0,0,0,0,0,0,0,0,"brak", "brak", "brak", "brak","brak",
                    "brak","brak",100,100,100,100,"brak",1,"1x1");
            uzytkownikService.create(user);
        }
        return new ModelAndView("login", "uzytkownik", user);
    }
}
