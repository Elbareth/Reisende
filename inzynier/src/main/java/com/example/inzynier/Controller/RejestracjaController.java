package com.example.inzynier.Controller;

import com.example.inzynier.BasicService.HashPassword;
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

@Controller
public class RejestracjaController {
    @Autowired
    private UzytkownikService uzytkownikService;
    private HashPassword hash = new HashPassword();
    @GetMapping("/zarejestruj")
    public ModelAndView zarejestruj(){
        return new ModelAndView("/rejestracja", "uzytkownik", new UzytkownikRejestracjaDTO());
    }
    @PostMapping(value = "/register", consumes = "multipart/form-data", produces = { "application/json", "application/xml" })
    public ModelAndView register(@ModelAttribute("uzytkownik") UzytkownikRejestracjaDTO uzytkownikRejestracjaDTO, ModelMap model){
        UzytkownikDTO user;
        if(uzytkownikService.isThisLoginInUse(uzytkownikRejestracjaDTO.getLogin())){
            model.put("error","Wybrany login jest juz zajety");
            return new ModelAndView("rejestracja","uzytkownik",new UzytkownikRejestracjaDTO());
        }
        else{
            String shaszowaneHaslo = null;
            shaszowaneHaslo = hash.hashMyPassword(uzytkownikRejestracjaDTO.getHaslo(), shaszowaneHaslo);
             user = new UzytkownikDTO(
                     uzytkownikRejestracjaDTO.getLogin(),
                     shaszowaneHaslo,
                     uzytkownikRejestracjaDTO.getNick(),
                    uzytkownikRejestracjaDTO.getKlasaPostaci(),
                     100,
                     0,
                     "Szatyn Wojownik",
                     uzytkownikRejestracjaDTO.getPlec(),
                     0,
                     0,
                     0,
                     0,
                     0,
                     0,
                     0,
                     0,
                     "brak",
                     "brak",
                     "brak",
                     "brak",
                     "brak",
                    "brak",
                     "brak",
                     100,
                     100,
                     100,
                     100,
                     "brak",
                     1,
                     "1x1");
            uzytkownikService.create(user);
            //TODO Dodaj domek
        }
        return new ModelAndView("login", "uzytkownik", user);
    }
}
