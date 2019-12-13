package com.example.inzynier.Controller;

import com.example.inzynier.BasicService.HashPassword;
import com.example.inzynier.DTO.DomekDTO;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.DTO.UzytkownikRejestracjaDTO;
import com.example.inzynier.Service.DomekService;
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
    @Autowired
    private DomekService domekService;
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
                     "tlo6.jpg-1300x800");
            uzytkownikService.create(user);
            DomekDTO domekDTO = new DomekDTO(user.getLogin(),
                    "20x20",
                    "BialeOkno-100x5",
                    "ProsteDrzwi-100x190",
                    "SlomianeLozko-20x20",
                    "",
                    "",
                    "Wiadro-150x50",
                    "",
                    "",
                    "",
                    "DziuraWZiemi-150x150",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "");
            domekService.create(domekDTO);
        }
        return new ModelAndView("login", "uzytkownik", user);
    }
}
