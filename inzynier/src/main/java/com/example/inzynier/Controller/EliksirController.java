package com.example.inzynier.Controller;

import com.example.inzynier.DTO.EkwipunekDTO;
import com.example.inzynier.DTO.EliksirDTO;
import com.example.inzynier.DTO.PlecakDTO;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.Service.EkwipunekService;
import com.example.inzynier.Service.EliksirService;
import com.example.inzynier.Service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EliksirController {
    @Autowired
    private EliksirService eliksirService;
    @Autowired
    private EkwipunekService ekwipunekService;
    @Autowired
    private UzytkownikService uzytkownikService;
    @GetMapping("/eliksir")
    public ModelAndView getListEliksir(HttpSession sesja, ModelMap modelMap){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        List<PlecakDTO> plecak = new ArrayList<>();
        modelMap.put("eliksir", eliksirService.findAll());
        ekwipunekService.findByWlasciciel(uzytkownikService.findByLogin((String) sesja.getAttribute("login"))).forEach(it ->{
            final boolean[] haveIt = {false};
            plecak.forEach( at ->{
                if(at.getNazwa().equals(it.getNazwa())){
                    at.setIlosc(at.getIlosc() + 1);
                    haveIt[0] = true;
                }
            });
            if(!haveIt[0]){
                PlecakDTO plecakDTO = new PlecakDTO(it.getNazwa(), 1);
                plecak.add(plecakDTO);
            }
        });
        modelMap.put("wlasciciel", plecak);
        return new ModelAndView("eliksir.index","uzytkownik",new UzytkownikDTO());
    }
    @PostMapping("eliksir")
    public ModelAndView kup(@RequestBody EliksirDTO eliksirDTO, HttpSession sesja, ModelMap modelMap){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        //dane ktore przyjda z frontu sa juz wyselekcjonowane
        //zabieramy pieniadze
        UzytkownikDTO uzytkownikDTO = uzytkownikService.findByLogin((String) sesja.getAttribute("login"));
        uzytkownikDTO.setZloteMonety(uzytkownikDTO.getZloteMonety() - eliksirDTO.getCena().intValue());
        uzytkownikService.update(uzytkownikDTO.getLogin(), uzytkownikDTO);
        //zabieramy surowce
        String [] tmp = eliksirDTO.getPrzepis().split(",");
        for (int i=0;i<tmp.length; i++){
            String liczba = tmp[i].replaceAll("\\D+","");
            String nazwa = tmp[i].replaceAll("[^A-Za-z]","");
            if (ekwipunekService.findByWlascicielAndNazwa(uzytkownikDTO, nazwa).size() >= Integer.parseInt(liczba)) {
                List<EkwipunekDTO> ekwipunekDTO = ekwipunekService.findByWlascicielAndNazwa(uzytkownikDTO, nazwa);
                for (int k = 0; k < Integer.parseInt(liczba); k++) {
                    ekwipunekService.delete(ekwipunekDTO.get(k).getId());
                }
                //dodajemy eliksir do ekwipunku
                EkwipunekDTO ekwipunekDTO1 = new EkwipunekDTO(uzytkownikDTO, eliksirDTO.getNazwa(), eliksirDTO.getPlik(), eliksirDTO.toString());
                ekwipunekService.create(ekwipunekDTO1);
            }
        }
        return getListEliksir(sesja, modelMap);
    }
}
