package com.example.inzynier.Controller;

import com.example.inzynier.DTO.*;
import com.example.inzynier.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MapaController {
    @Autowired
    private UzytkownikService uzytkownikService;
    @Autowired
    private BudynkiService budynkiService;
    @Autowired
    private DomekService domekService;
    @Autowired
    private DomekController domekController;
    @Autowired
    private PostacService postacService;
    @Autowired
    private DialogPostaciService dialogPostaciService;
    @Autowired
    private QuestyService questyService;
    @Autowired
    private ZadaniaService zadaniaService;
    @Autowired
    private ZiolaService ziolaService;
    @Autowired
    private ZbrojaService zbrojaService;
    @Autowired
    private EkwipunekService ekwipunekService;
    @Autowired
    private InnePrzedmiotyService innePrzedmiotyService;
    @Autowired
    private EliksirService eliksirService;
    private static Integer INDEXDIALOGU = 0;
    private static String DIALOGREMEMBER = null;
    @GetMapping("/maps")
    public ModelAndView mapa(HttpSession sesja, ModelMap modelMap){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        String login = (String) sesja.getAttribute("login");
        UzytkownikDTO uzytkownikDTO = uzytkownikService.findByLogin(login);
        String [] plansza = uzytkownikDTO.getPolozenie().split("-");
        modelMap.put("plansza", plansza[0]); // tu wyciagamy nazwe pliku
        modelMap.put("listInside", budynkiService.findByPlanszaInside(plansza[0]));
        modelMap.put("listOnClick", budynkiService.findByPlanszaOnClick(plansza[0]));
        modelMap.put("listaPostaci", postacService.findByPlansza(plansza[0]));
        String [] pozycja = plansza[1].split("x");
        modelMap.put("lewo",pozycja[0]);
        modelMap.put("gora",pozycja[1]);
        modelMap.put("rosliny", ziolaService.findByPlansza(plansza[0]));
        DomekDTO domek = domekService.findByWlasciciel(login);
        List<WyswietlMebleDTO> wyswietlMebleDTOList = new ArrayList<>();
        domekController.wyswietlMeble(domek, wyswietlMebleDTOList);
        modelMap.put("listaMebliDoWyswietlenia", wyswietlMebleDTOList);
        if(modelMap.get("dialog") != null) DIALOGREMEMBER = (String) modelMap.get("dialog");
        else modelMap.addAttribute("dialog", DIALOGREMEMBER);
        return new ModelAndView("mapa.index", "uzytkownik", uzytkownikDTO);
    }
    @PostMapping("/maps")
    public ModelAndView aktualizuj(HttpSession sesja, ModelMap modelMap, @RequestBody Postac postac){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        String login = (String) sesja.getAttribute("login");
        UzytkownikDTO uzytkownikDTO = uzytkownikService.findByLogin(login);
        postac.setLeft(postac.getLeft().replaceAll("\\D+",""));
        postac.setTop(postac.getTop().replaceAll("\\D+",""));
        postac.setPlansza(postac.getPlansza());
        postac = zmienPlansze(postac, modelMap, login);
        uzytkownikDTO.setPolozenie(postac.getPlansza()+"-"+postac.getLeft()+"x"+postac.getTop());
        uzytkownikService.update(login, uzytkownikDTO);
        modelMap.put("lewo",postac.getLeft());
        modelMap.put("gora",postac.getTop());
        modelMap.put("plansza", postac.getPlansza());
        modelMap.put("listInside", budynkiService.findByPlanszaInside(postac.getPlansza()));
        modelMap.put("listOnClick", budynkiService.findByPlanszaOnClick(postac.getPlansza()));
        modelMap.put("listaPostaci", postacService.findByPlansza(postac.getPlansza()));
        return new ModelAndView("mapa.index", "uzytkownik", uzytkownikDTO);
    }
    public Postac zmienPlansze(Postac postac, ModelMap modelMap, String login){
        if(postac.getPlansza().equals("mojDomekWnetrze.jpg")){
            DomekDTO domek = domekService.findByWlasciciel(login);
            List<WyswietlMebleDTO> wyswietlMebleDTOList = new ArrayList<>();
            domekController.wyswietlMeble(domek, wyswietlMebleDTOList);
            modelMap.put("listaMebliDoWyswietlenia", wyswietlMebleDTOList);
        }
        if(budynkiService.findByPlik(postac.getPlansza()) != null){
            BudynkiDTO budynek = budynkiService.findByPlik(postac.getPlansza());
            postac.setPlansza(budynek.getPlansza());
            postac.setLeft(budynek.getPolozenieX());
            String [] wielkosc = budynek.getWymiary().split("x");
            Integer suma = Integer.parseInt(budynek.getPolozenieY()) + 50 + Integer.parseInt(wielkosc[1]);
            postac.setTop(suma.toString()); // chcemy być 50 pikseli pod budynkiem, a polozenieY oznacza poczatek budynku
            return postac;
        }
        else if(Integer.parseInt(postac.getLeft()) <= 49 ){ // ruch w lewo
            Integer numer = Integer.parseInt(postac.getPlansza().replaceAll("\\D+",""));
            if(numer % 5 == 1){
                return postac; // jeśli dotraliśmy do granicy to nic nie zmieniamy
            }
            numer = numer -1;
            postac.setPlansza("tlo"+numer+".jpg");
            postac.setLeft("2499");
            return postac;
        }
        else if(Integer.parseInt(postac.getLeft()) >= 2500){ // ruch w prawo
            Integer numer = Integer.parseInt(postac.getPlansza().replaceAll("\\D+",""));
            if(numer % 5 == 0){
                return postac; // jeśli dotarliśmy do granicy to nic nie zmieniamy
            }
            numer = numer + 1;
            postac.setPlansza("tlo"+numer+".jpg");
            postac.setLeft("50");
            return postac;
        }
        else if(Integer.parseInt(postac.getTop()) <= 49){ // ruch w gore
            Integer numer = Integer.parseInt(postac.getPlansza().replaceAll("\\D+",""));
            if(numer >= 1 && numer <=5){
                return postac; // jeśli dotarliśmy do granicy to nic nie zmieniamy
            }
            numer = numer - 5;
            postac.setPlansza("tlo"+numer+".jpg");
            postac.setTop("1899");
            return postac;
        }
        else if(Integer.parseInt(postac.getTop()) >= 1900){ // ruch w dól
            Integer numer = Integer.parseInt(postac.getPlansza().replaceAll("\\D+",""));
            if(numer >= 16 && numer <=20){
                return postac; // jeśli dotarliśmy do granicy to nic nie zmieniamy
            }
            else {
                numer = numer + 5;
                postac.setPlansza("tlo" + numer + ".jpg");
                postac.setTop("50");
                return postac;
            }
        }
        return postac; //jesli nie zwracamy postac bez zmian
    }
    @PatchMapping("/maps")
    public ModelAndView zaspokajaniePotrzeb(@RequestBody PotrzebyDTO potrzebyDTO, ModelMap modelMap, HttpSession sesja){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        UzytkownikDTO uzytkownikDTO = uzytkownikService.findByLogin((String) sesja.getAttribute("login"));
        uzytkownikDTO.setGlod(Integer.parseInt(potrzebyDTO.getGlod()));
        uzytkownikDTO.setPragnienie(Integer.parseInt(potrzebyDTO.getPragnienie()));
        uzytkownikDTO.setSen(Integer.parseInt(potrzebyDTO.getSen()));
        uzytkownikDTO.setHigiena(Integer.parseInt(potrzebyDTO.getHigiena()));
        uzytkownikService.update((String) sesja.getAttribute("login"), uzytkownikDTO);
        return mapa(sesja, modelMap);
    }
    @PutMapping("/maps")
    public ModelAndView zdobyteSurowce(@RequestBody SurowceDTO surowceDTO,  HttpSession sesja, ModelMap modelMap){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        UzytkownikDTO uzytkownikDTO = uzytkownikService.findByLogin((String) sesja.getAttribute("login"));
        uzytkownikDTO.setDrewno(Integer.parseInt(surowceDTO.getDrewno()));
        uzytkownikDTO.setGrudkaGliny(Integer.parseInt(surowceDTO.getGlina()));
        uzytkownikDTO.setGrudkaZelaza(Integer.parseInt(surowceDTO.getZelazo()));
        uzytkownikDTO.setWorekZboza(Integer.parseInt(surowceDTO.getZboze()));
        uzytkownikDTO.setDeski(Integer.parseInt(surowceDTO.getDeski()));
        uzytkownikDTO.setCegly(Integer.parseInt(surowceDTO.getCegla()));
        uzytkownikDTO.setSztabkaZelaza(Integer.parseInt(surowceDTO.getSztabkaZelaza()));
        uzytkownikDTO.setChleb(Integer.parseInt(surowceDTO.getChleb()));
        uzytkownikDTO.setPragnienie(Integer.parseInt(surowceDTO.getStudnia()));
        uzytkownikService.update(uzytkownikDTO.getLogin(), uzytkownikDTO);
        return mapa(sesja, modelMap);
    }
    @PostMapping("/maps/dialog")
    public ModelAndView dialog(@RequestBody DialogDTO dialogDTO, HttpSession sesja, ModelMap modelMap){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        //Przypdaek gdy dialog juz byl odtwarzany
        //Przypadek gdy dopiero zaczynamy rozmowe
        //Przypdaek gdy rozmowa sie konczy
        //Co z przypadkiem gdy zatrzymujemy sie w polowie?
        String login = (String) sesja.getAttribute("login");
        PostacDTO postacDTO = postacService.findByPlik(dialogDTO.getPostac());
        List<ZadaniaDTO> zadaniaDTO = zadaniaService.findByPostac(postacDTO.getImie());
        final ZadaniaDTO[] mojeZadanie = {new ZadaniaDTO()};
        zadaniaDTO.forEach( it ->{
            List<QuestyDTO> mojeQuesty =  questyService.findByNoweZadanieAndWykonujacyAndCzyWykonane(it.getNazwa(), login,false);
            if(mojeQuesty.size() > 0){
                mojeZadanie[0] = zadaniaService.findByNazwa(mojeQuesty.get(0).getNoweZadanie());
            }
            else mojeZadanie[0] = zadaniaDTO.get(0);
        });

        List<DialogPostaciDTO> dialogPostaciDTO = dialogPostaciService.findByNazwaQuestaAndPostac(mojeZadanie[0].getNazwa(), postacDTO.getImie());
        DialogPostaciDTO dialog;
        try{
            dialog = dialogPostaciDTO.get(INDEXDIALOGU);
        }
        catch(IndexOutOfBoundsException e){
            INDEXDIALOGU = dialogPostaciDTO.size() - 1;
            dialog = dialogPostaciDTO.get(dialogPostaciDTO.size() - 1);
        }
        if(questyService.findByNoweZadanie(dialog.getNazwaQuesta(), login) != null ){
            QuestyDTO questyDTO = questyService.findByNoweZadanie(dialog.getNazwaQuesta(), login);
            String [] tmp = questyDTO.getNoweZadanie().split("-");
            INDEXDIALOGU = Integer.parseInt(tmp[1]) + 1;
            if(dialogPostaciDTO.size() <= INDEXDIALOGU){
                dialog = dialogPostaciDTO.get(dialogPostaciDTO.size() - 1);
                modelMap.put("dialog", dialog.getTekst());
                INDEXDIALOGU  = dialogPostaciDTO.size() - 1;
                questyDTO.setCzyWykonane(true); // zadanie uznajemy za wykonane bo dotarlismy do ostatniego dialogu
                questyService.update(questyDTO.getId(), questyDTO);
                nagroda(questyDTO.getNagroda(), uzytkownikService.findByLogin(login));

            }
            else{
                dialog = dialogPostaciDTO.get(INDEXDIALOGU);
                modelMap.put("dialog", dialog.getTekst());
                questyDTO.setNoweZadanie(tmp[0]+"-"+INDEXDIALOGU);
                questyService.update(questyDTO.getId(), questyDTO);
                INDEXDIALOGU++;
            }
        }
        else{
            modelMap.put("dialog", dialog.getTekst());
            QuestyDTO questyDTO = new QuestyDTO(
                    postacDTO.getImie(),
                    login,
                    zadaniaService.findByNazwa(dialog.getNazwaQuesta()).getNazwa()+"-"+INDEXDIALOGU,
                    zadaniaService.findByNazwa(dialog.getNazwaQuesta()).getTresc(),
                    zadaniaService.findByNazwa(dialog.getNazwaQuesta()).getNagroda(),
                    false);
            questyService.create(questyDTO);
            INDEXDIALOGU++;
        }
        return mapa(sesja, modelMap);
    }
    @GetMapping("/zadania")
    public ModelAndView zadania(HttpSession sesja, ModelMap modelMap){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        String login =  (String) sesja.getAttribute("login");
        UzytkownikDTO uzytkownikDTO = uzytkownikService.findByLogin(login);
        modelMap.addAttribute("rozwiazaneZadania", questyService.findByWykonujacyAndCzyWykonane(login, true));
        modelMap.addAttribute("nierozwiazaneZadania", questyService.findByWykonujacyAndCzyWykonane(login, false));
        return new ModelAndView("zadania.index","uzytkonik",uzytkownikDTO);
    }
    private void nagroda(String nagroda, UzytkownikDTO uzytkownikDTO){
        String [] listaNagrod = nagroda.split(","); // zadania sa od siebie oddzielone przecinkami
        for (int i=0; i< listaNagrod.length; i++){
            String liczba = listaNagrod[i].replaceAll("\\D+","");
            String nazwa = listaNagrod[i].replaceAll("[^A-Za-z]","");
            if(nazwa.equals("Doswiadczenia")){
                uzytkownikDTO.setDoswiadczenie(uzytkownikDTO.getDoswiadczenie() + Integer.parseInt(liczba));
            }
            else if(nazwa.equals("Zlota")){
                uzytkownikDTO.setZloteMonety(uzytkownikDTO.getZloteMonety() + Integer.parseInt(liczba));
            }
            else if(nazwa.equals("MaxPotrzeby")){
                uzytkownikDTO.setGlod(100);
                uzytkownikDTO.setPragnienie(100);
                uzytkownikDTO.setSen(100);
                uzytkownikDTO.setHigiena(100);
            }
            uzytkownikService.update(uzytkownikDTO.getLogin(), uzytkownikDTO);
//            if(ekwipunekService.findByWlascicielAndNazwa(uzytkownikDTO, nazwa).size() > 0){
//                List<EkwipunekDTO> ekwipunekDTO = ekwipunekService.findByWlascicielAndNazwa(uzytkownikDTO, nazwa);
//                ekwipunekDTO.get(0).setIlosc(ekwipunekDTO.get(0).getIlosc() + 1); // Mamy o jeden wiecej danego przedmitu
//                ekwipunekService.update(ekwipunekDTO.get(0).getId(), ekwipunekDTO.get(0));
//            }
            try{
                ZbrojaDTO zbrojaDTO = zbrojaService.findByNazwa(nazwa);
                EkwipunekDTO ekwipunekDTO = new EkwipunekDTO(
                    uzytkownikDTO,
                    nazwa,
                    zbrojaDTO.getPlik(),
                    zbrojaDTO.toString());
                ekwipunekService.create(ekwipunekDTO);
            }
            catch(EntityNotFoundException e){}
            try {
                InnePrzedmiotyDTO innePrzedmiotyDTO = innePrzedmiotyService.findByNazwa(nazwa);
                EkwipunekDTO ekwipunekDTO = new EkwipunekDTO(
                        uzytkownikDTO,
                        nazwa,
                        innePrzedmiotyDTO.getPlik(),
                        innePrzedmiotyDTO.getOpis());
                ekwipunekService.create(ekwipunekDTO);
            }
            catch (EntityNotFoundException e){}
            try{
                EliksirDTO eliksirDTO = eliksirService.findByNazwa(nazwa);
                EkwipunekDTO ekwipunekDTO = new EkwipunekDTO(
                        uzytkownikDTO,
                        nazwa,
                        eliksirDTO.getPlik(),
                        eliksirDTO.toString());
                ekwipunekService.create(ekwipunekDTO);
            }
            catch(EntityNotFoundException e){}
        }
    }
    @PostMapping("/maps/roslina")
    public ModelAndView zbierzZiola(@RequestBody RoslinyDTO roslinyDTO, HttpSession sesja, ModelMap modelMap){
        ZiolaDTO ziolaDTO = ziolaService.findByPlik(roslinyDTO.getRoslina());
        EkwipunekDTO ekwipunekDTO = new EkwipunekDTO(
                uzytkownikService.findByLogin((String)sesja.getAttribute("login")),
                roslinyDTO.getRoslina(),
                ziolaDTO.getPlik(),
                ziolaDTO.getOpis());
        ekwipunekService.create(ekwipunekDTO);
        return mapa(sesja, modelMap);
    }
}
