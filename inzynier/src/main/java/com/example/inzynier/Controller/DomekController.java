package com.example.inzynier.Controller;

import com.example.inzynier.DTO.*;
import com.example.inzynier.Service.DomekService;
import com.example.inzynier.Service.MebleService;
import com.example.inzynier.Service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DomekController {
    @Autowired
    private DomekService domekService;
    @Autowired
    private UzytkownikService uzytkownikService;
    @Autowired
    private MebleService mebleService;
    public void wyswietlMeble(DomekDTO domek, List<WyswietlMebleDTO> wyswietlMebleDTOList){
        if(!domek.getBarek().equals("")){
            String [] array = domek.getBarek().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getDrzwi().equals("")) {
            String [] array = domek.getDrzwi().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getDywany().equals("")) {
            String [] array = domek.getDywany().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getFotele().equals("")) {
            String [] array = domek.getFotele().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getKojec().equals("")) {
            String [] array = domek.getKojec().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getKominki().equals("")) {
            String[] array = domek.getKominki().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getKrzesla().equals("")) {
            String [] array = domek.getKrzesla().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getKuchenka().equals("")) {
            String [] array = domek.getKuchenka().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getKwiaty().equals("")) {
            String [] array = domek.getKwiaty().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getLodowka().equals("")) {
            String [] array = domek.getLodowka().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getLozko().equals("")) {
            String[] array = domek.getLozko().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getObraz().equals("")) {
            String [] array = domek.getObraz().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getOkna().equals("")) {
            String [] array = domek.getOkna().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getPodloga().equals("")) {
            String [] array = domek.getPodloga().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getSofa().equals("")) {
            String [] array = domek.getSofa().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getStoly().equals("")) {
            String [] array = domek.getStoly().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getSzafa().equals("")) {
            String [] array = domek.getSzafa().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getSzafki().equals("")) {
            String [] array = domek.getSzafki().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getToaeta().equals("")) {
            String [] array = domek.getToaeta().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getTrofea().equals("")) {
            String [] array = domek.getTrofea().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getUmywalka().equals("")) {
            String [] array = domek.getUmywalka().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getWanna().equals("")) {
            String [] array = domek.getWanna().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getWazony().equals("")) {
            String [] array = domek.getWazony().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
        if(!domek.getZlew().equals("")){
            String [] array = domek.getZlew().split(" ");
            listaMebliDoWyswietlenia(array, wyswietlMebleDTOList);
        }
    }
    @GetMapping("/dom")
    public ModelAndView getDomek(HttpSession sesja, ModelMap model){
        if(sesja.getAttribute("login") == null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        DomekDTO domek = domekService.findByWlasciciel((String) sesja.getAttribute("login"));
        model.put("uzytkownik", uzytkownikService.findByLogin((String) sesja.getAttribute("login")));
        String [] pomieszczenia = domek.getPomieszczenia().split("x");
        model.put("pomieszczenia", new WymiaryDTO(Integer.parseInt(pomieszczenia[0]),Integer.parseInt(pomieszczenia[1])));
        List<WyswietlMebleDTO> wyswietlMebleDTOList = new ArrayList<>();
        wyswietlMeble(domek, wyswietlMebleDTOList);
        model.addAttribute("listaMebliDoWyswietlenia", wyswietlMebleDTOList);
        model.addAttribute("listaDoKuchnii",mebleService.getListKuchnii());
        model.addAttribute("listaDoLazienki",mebleService.getListLazienki());
        model.addAttribute("listaDoSypialnii",mebleService.getListSypialnii());
        model.addAttribute("listaDoodatki",mebleService.getListDodatki());
        return new ModelAndView("dom.index", "domek", domek);
    }

    private List<WyswietlMebleDTO> listaMebliDoWyswietlenia(String [] array, List<WyswietlMebleDTO> wyswietlMebleDTOList){
        for(int i = 0;i<array.length;i++){
            if(!array[i].equals("")) {
                String[] nazwa = array[i].split("-");
                MebleDTO mebel = mebleService.getByNazwa(nazwa[0]);
                String plik = "/resources/" + mebel.getPlik();
                WyswietlMebleDTO wyswietlMebleDTO = new WyswietlMebleDTO();
                String[] wymiary = nazwa[1].split("x");
                wyswietlMebleDTO.setPlik(plik);
                wyswietlMebleDTO.setWymiarX(wymiary[0]);
                wyswietlMebleDTO.setWymiarY(wymiary[1]);
                wyswietlMebleDTO.setKategoria(mebel.getKategoria());
                wyswietlMebleDTO.setGlod(mebel.getGlod().toString());
                wyswietlMebleDTO.setPragnienie(mebel.getPragnienie().toString());
                wyswietlMebleDTO.setHigiena(mebel.getHigiena().toString());
                wyswietlMebleDTO.setSen(mebel.getSen().toString());
                wyswietlMebleDTOList.add(wyswietlMebleDTO);
            }
        }
        return wyswietlMebleDTOList;
    }

    @PostMapping("/dom")
    public ModelAndView kupMebel(@RequestBody KupowanieMebliDTO kupowanieMebliDTO, HttpSession sesja, ModelMap model){
        if(sesja.getAttribute("login") == null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        String [] array = kupowanieMebliDTO.getNazwa().split("/");
        MebleDTO mebel = mebleService.findByPlik(array[4]);
        String doZapisu = mebel.getNazwa()+"-"+kupowanieMebliDTO.getWymiarX().replace("px","")+"x"+kupowanieMebliDTO.getWymiarY().replace("px","");
        DomekDTO domek = domekService.findByWlasciciel((String) sesja.getAttribute("login"));
        switch (mebel.getKategoria()){
            case "Barki":
                if(domek.getBarek().equals("")) domek.setBarek(domek.getBarek());
                else domek.setBarek(domek.getBarek() + " " + doZapisu);
                break;
            case "Drzwi":
                if(domek.getDrzwi().equals("")) domek.setDrzwi(domek.getDrzwi());
                else domek.setDrzwi(domek.getDrzwi() + " " + doZapisu);
                break;
            case "Dywany":
                if(domek.getDywany().equals("")) domek.setDywany(domek.getDywany());
                else domek.setDywany(domek.getDywany() + " " + doZapisu);
                break;
            case "Fotele":
                if(domek.getFotele().equals("")) domek.setFotele(domek.getFotele());
                else domek.setFotele(domek.getFotele() + " " + doZapisu);
                break;
            case "Kojec":
                if(domek.getKojec().equals("")) domek.setKojec(domek.getKojec());
                else domek.setKojec(domek.getKojec() + " " + doZapisu);
                break;
            case "Kominki":
                if(domek.getKominki().equals("")) domek.setKominki(domek.getKominki());
                else domek.setKominki(domek.getKominki() + " " + doZapisu);
                break;
            case "Krzesla":
                if(domek.getKrzesla().equals("")) domek.setKrzesla(domek.getKrzesla());
                else domek.setKrzesla(domek.getKrzesla() + " " + doZapisu);
                break;
            case "Kuchnia":
                if(domek.getKuchenka().equals("")) domek.setKuchenka(domek.getKuchenka());
                else domek.setKuchenka(domek.getKuchenka() + " " + doZapisu);
                break;
            case "Kwiaty":
                if(domek.getKwiaty().equals("")) domek.setKwiaty(domek.getKwiaty());
                else domek.setKwiaty(domek.getKwiaty() + " " + doZapisu);
                break;
            case "Lodowki":
                if(domek.getLodowka().equals("")) domek.setLodowka(domek.getLodowka());
                else domek.setLodowka(domek.getLodowka() + " " + doZapisu);
                break;
            case "Lozka":
                if(domek.getLozko().equals("")) domek.setLozko(domek.getLozko());
                else domek.setLozko(domek.getLozko() + " " + doZapisu);
                break;
            case "Obrazy":
                if(domek.getObraz().equals("")) domek.setObraz(domek.getObraz());
                else domek.setObraz(domek.getObraz() + " " + doZapisu);
                break;
            case "Okna":
                if(domek.getOkna().equals("")) domek.setOkna(domek.getOkna());
                else domek.setOkna(domek.getOkna() + " " + doZapisu);
                break;
            case "Podloga":
                if(domek.getPodloga().equals("")) domek.setPodloga(domek.getPodloga());
                else domek.setPodloga(domek.getPodloga() + " " + doZapisu);
                break;
            case "Sofa":
                if(domek.getSofa().equals("")) domek.setSofa(domek.getSofa());
                else domek.setSofa(domek.getSofa() + " " + doZapisu);
                break;
            case "Stoly":
                if(domek.getStoly().equals("")) domek.setStoly(domek.getStoly());
                else domek.setStoly(domek.getStoly() + " " + doZapisu);
                break;
            case "Szafa":
                if(domek.getSzafa().equals("")) domek.setSzafa(domek.getSzafa());
                else domek.setSzafa(domek.getSzafa() + " " + doZapisu);
                break;
            case "Szafki":
                if(domek.getSzafki().equals("")) domek.setSzafki(domek.getSzafki());
                else domek.setSzafki(domek.getSzafki() + " " + doZapisu);
                break;
            case "Toalety":
                if(domek.getToaeta().equals("")) domek.setToaeta(domek.getToaeta());
                else domek.setToaeta(domek.getToaeta() + " " + doZapisu);
                break;
            case "Trofea":
                if(domek.getTrofea().equals("")) domek.setTrofea(domek.getTrofea());
                else domek.setToaeta(domek.getToaeta() + " " + doZapisu);
                break;
            case "Umywalki":
                if(domek.getUmywalka().equals("")) domek.setUmywalka(domek.getUmywalka());
                else domek.setUmywalka(domek.getUmywalka() + " " + doZapisu);
                break;
            case "Wanna":
                if(domek.getWanna().equals("")) domek.setWanna(domek.getWanna());
                else domek.setWanna(domek.getWanna() + " " + doZapisu);
                break;
            case "Wazony":
                if(domek.getWazony().equals("")) domek.setWazony(domek.getWazony());
                else domek.setWazony(domek.getWazony() + " " + doZapisu);
                break;
            case "Zlew":
                if(domek.getZlew().equals("")) domek.setZlew(domek.getZlew());
                else domek.setZlew(domek.getZlew() + " " + doZapisu);
                break;
        }
        domekService.update((String) sesja.getAttribute("login"), domek);
        UzytkownikDTO uzytkownikDTO = uzytkownikService.findByLogin((String) sesja.getAttribute("login"));
        uzytkownikDTO.setZloteMonety(Integer.parseInt(kupowanieMebliDTO.getPieniadze()));
        uzytkownikDTO.setDoswiadczenie(uzytkownikDTO.getDoswiadczenie()+mebel.getDoswiadczenia());
        uzytkownikService.update((String) sesja.getAttribute("login"), uzytkownikDTO);
        return getDomek(sesja, model);
    }

    @PatchMapping("/dom")
    public ModelAndView updateMeble(@RequestBody PrzenoszenieMebliDTO przenoszenieMebliDTO, HttpSession sesja, ModelMap model){
        if(sesja.getAttribute("login") == null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        String [] array = przenoszenieMebliDTO.getNazwa().split("/");
        MebleDTO mebleDTO = mebleService.findByPlik(array[4]);
        String nazwa = mebleDTO.getNazwa();
        String szukana = nazwa+"-"+przenoszenieMebliDTO.getStaraPozycjaX().replace("px","")+"x"+przenoszenieMebliDTO.getStaraPozycjaY().replace("px","");
        String doZapisu = nazwa+"-"+przenoszenieMebliDTO.getWymiarX().replace("px","")+"x"+przenoszenieMebliDTO.getWymiarY().replace("px","");
        DomekDTO domek = domekService.findByWlasciciel((String) sesja.getAttribute("login"));
        switch (mebleDTO.getKategoria()){
            case "Barki":
                String [] tmp1 = domek.getBarek().split(" ");
                String zapisz1 = update(tmp1, szukana, doZapisu);
                domek.setBarek(zapisz1);
                break;
            case "Drzwi":
                String [] tmp2 = domek.getDrzwi().split(" ");
                String zapisz2 = update(tmp2, szukana, doZapisu);
                domek.setDrzwi(zapisz2);
                break;
            case "Dywany":
                String [] tmp3 = domek.getDywany().split(" ");
                String zapisz3 = update(tmp3, szukana, doZapisu);
                domek.setDywany(zapisz3);
                break;
            case "Fotele":
                String [] tmp4 = domek.getFotele().split(" ");
                String zapisz4 = update(tmp4, szukana, doZapisu);
                domek.setFotele(zapisz4);
                break;
            case "Kojec":
                String [] tmp5 = domek.getKojec().split(" ");
                String zapisz5 = update(tmp5, szukana, doZapisu);
                domek.setKojec(zapisz5);
                break;
            case "Kominki":
                String [] tmp6 = domek.getKojec().split(" ");
                String zapisz6 = update(tmp6, szukana, doZapisu);
                domek.setKojec(zapisz6);
                break;
            case "Krzesla":
                String [] tmp7 = domek.getKrzesla().split(" ");
                String zapisz7 = update(tmp7, szukana, doZapisu);
                domek.setKrzesla(zapisz7);
                break;
            case "Kuchnia":
                String [] tmp8 = domek.getKuchenka().split(" ");
                String zapisz8 = update(tmp8, szukana, doZapisu);
                domek.setKuchenka(zapisz8);
                break;
            case "Kwiaty":
                String [] tmp9 = domek.getKwiaty().split(" ");
                String zapisz9 = update(tmp9, szukana, doZapisu);
                domek.setKuchenka(zapisz9);
                break;
            case "Lodowki":
                String [] tmp10 = domek.getLodowka().split(" ");
                String zapisz10 = update(tmp10, szukana, doZapisu);
                domek.setLodowka(zapisz10);
                break;
            case "Lozka":
                String [] tmp11 = domek.getLozko().split(" ");
                String zapisz11 = update(tmp11, szukana, doZapisu);
                domek.setLozko(zapisz11);
                break;
            case "Obrazy":
                String [] tmp12 = domek.getObraz().split(" ");
                String zapisz12 = update(tmp12, szukana, doZapisu);
                domek.setObraz(zapisz12);
                break;
            case "Okna":
                String [] tmp13 = domek.getOkna().split(" ");
                String zapisz13 = update(tmp13, szukana, doZapisu);
                domek.setOkna(zapisz13);
                break;
            case "Podloga":
                String [] tmp14 = domek.getPodloga().split(" ");
                String zapisz14 = update(tmp14, szukana, doZapisu);
                domek.setPodloga(zapisz14);
                break;
            case "Sofa":
                String [] tmp15 = domek.getSofa().split(" ");
                String zapisz15 = update(tmp15, szukana, doZapisu);
                domek.setSofa(zapisz15);
                break;
            case "Stoly":
                String [] tmp16 = domek.getStoly().split(" ");
                String zapisz16 = update(tmp16, szukana, doZapisu);
                domek.setStoly(zapisz16);
                break;
            case "Szafa":
                String [] tmp17 = domek.getSzafa().split(" ");
                String zapisz17 = update(tmp17, szukana, doZapisu);
                domek.setSzafa(zapisz17);
                break;
            case "Szafki":
                String [] tmp18 = domek.getSzafki().split(" ");
                String zapisz18 = update(tmp18, szukana, doZapisu);
                domek.setSzafki(zapisz18);
                break;
            case "Toalety":
                String [] tmp19 = domek.getToaeta().split(" ");
                String zapisz19 = update(tmp19, szukana, doZapisu);
                domek.setToaeta(zapisz19);
                break;
            case "Trofea":
                String [] tmp20 = domek.getTrofea().split(" ");
                String zapisz20 = update(tmp20, szukana, doZapisu);
                domek.setTrofea(zapisz20);
                break;
            case "Umywalki":
                String [] tmp21 = domek.getUmywalka().split(" ");
                String zapisz21 = update(tmp21, szukana, doZapisu);
                domek.setUmywalka(zapisz21);
                break;
            case "Wanna":
                String [] tmp22 = domek.getWanna().split(" ");
                String zapisz22 = update(tmp22, szukana, doZapisu);
                domek.setWanna(zapisz22);
                break;
            case "Wazony":
                String [] tmp23 = domek.getWazony().split(" ");
                String zapisz23 = update(tmp23, szukana, doZapisu);
                domek.setWazony(zapisz23);
                break;
            case "Zlew":
                String [] tmp24 = domek.getZlew().split(" ");
                String zapisz24 = update(tmp24, szukana, doZapisu);
                domek.setZlew(zapisz24);
                break;
        }
        domekService.update((String) sesja.getAttribute("login"), domek);
        return getDomek(sesja, model);
    }

    private String update(String [] tmp, String szukana, String doZapisu){
        String zapisz = "";
        for(int i =0; i< tmp.length; i++){
            if(tmp[i].equals(szukana)){
                tmp[i] = doZapisu;
            }
            if(zapisz.equals("")) zapisz = tmp[i];
            else zapisz = zapisz + " "+tmp[i];
        }
        return zapisz;
    }

    @DeleteMapping("/dom")
    public ModelAndView usuwanieMebli(@RequestBody UsunMebelDTO usunMebelDTO, HttpSession sesja, ModelMap model){
        if(sesja.getAttribute("login") == null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        String [] array = usunMebelDTO.getNazwa().split("/");
        MebleDTO mebleDTO = mebleService.findByPlik(array[4]);
        String nazwa = mebleDTO.getNazwa();
        String szukana = nazwa+"-"+usunMebelDTO.getWymiarX().replace("px","")+"x"+usunMebelDTO.getWymiarY().replace("px","");
        DomekDTO domek = domekService.findByWlasciciel((String) sesja.getAttribute("login"));
        switch (mebleDTO.getKategoria()){
            case "Barki":
                String [] tmp1 = domek.getBarek().split(" ");
                String zapisz1 = usun(tmp1, szukana);
                domek.setBarek(zapisz1);
                break;
            case "Drzwi":
                String [] tmp2 = domek.getDrzwi().split(" ");
                String zapisz2 = usun(tmp2, szukana);
                domek.setDrzwi(zapisz2);
                break;
            case "Dywany":
                String [] tmp3 = domek.getDywany().split(" ");
                String zapisz3 = usun(tmp3, szukana);
                domek.setDywany(zapisz3);
                break;
            case "Fotele":
                String [] tmp4 = domek.getFotele().split(" ");
                String zapisz4 = usun(tmp4, szukana);
                domek.setFotele(zapisz4);
                break;
            case "Kojec":
                String [] tmp5 = domek.getKojec().split(" ");
                String zapisz5 = usun(tmp5, szukana);
                domek.setKojec(zapisz5);
                break;
            case "Kominki":
                String [] tmp6 = domek.getKominki().split(" ");
                String zapisz6 = usun(tmp6, szukana);
                domek.setKominki(zapisz6);
                break;
            case "Krzesla":
                String [] tmp7 = domek.getKrzesla().split(" ");
                String zapisz7 = usun(tmp7, szukana);
                domek.setKrzesla(zapisz7);
                break;
            case "Kuchnia":
                String [] tmp8 = domek.getKuchenka().split(" ");
                String zapisz8 = usun(tmp8, szukana);
                domek.setKuchenka(zapisz8);
                break;
            case "Kwiaty":
                String [] tmp9 = domek.getKwiaty().split(" ");
                String zapisz9 = usun(tmp9, szukana);
                domek.setKwiaty(zapisz9);
                break;
            case "Lodowki":
                String [] tmp10 = domek.getLodowka().split(" ");
                String zapisz10 = usun(tmp10, szukana);
                domek.setLodowka(zapisz10);
                break;
            case "Lozka":
                String [] tmp11 = domek.getLozko().split(" ");
                String zapisz11 = usun(tmp11, szukana);
                domek.setLozko(zapisz11);
                break;
            case "Obrazy":
                String [] tmp12 = domek.getObraz().split(" ");
                String zapisz12 = usun(tmp12, szukana);
                domek.setObraz(zapisz12);
                break;
            case "Okna":
                String [] tmp13 = domek.getOkna().split(" ");
                String zapisz13 = usun(tmp13, szukana);
                domek.setOkna(zapisz13);
                break;
            case "Podloga":
                String [] tmp14 = domek.getPodloga().split(" ");
                String zapisz14 = usun(tmp14, szukana);
                domek.setPodloga(zapisz14);
                break;
            case "Sofa":
                String [] tmp15 = domek.getSofa().split(" ");
                String zapisz15 = usun(tmp15, szukana);
                domek.setSofa(zapisz15);
                break;
            case "Stoly":
                String [] tmp16 = domek.getStoly().split(" ");
                String zapisz16 = usun(tmp16, szukana);
                domek.setStoly(zapisz16);
                break;
            case "Szafa":
                String [] tmp17 = domek.getSzafa().split(" ");
                String zapisz17 = usun(tmp17, szukana);
                domek.setSzafa(zapisz17);
                break;
            case "Szafki":
                String [] tmp18 = domek.getSzafki().split(" ");
                String zapisz18 = usun(tmp18, szukana);
                domek.setSzafki(zapisz18);
                break;
            case "Toalety":
                String [] tmp19 = domek.getToaeta().split(" ");
                String zapisz19 = usun(tmp19, szukana);
                domek.setToaeta(zapisz19);
                break;
            case "Trofea":
                String [] tmp20 = domek.getTrofea().split(" ");
                String zapisz20 = usun(tmp20, szukana);
                domek.setTrofea(zapisz20);
                break;
            case "Umywalki":
                String [] tmp21 = domek.getUmywalka().split(" ");
                String zapisz21 = usun(tmp21, szukana);
                domek.setUmywalka(zapisz21);
                break;
            case "Wanna":
                String [] tmp22 = domek.getWanna().split(" ");
                String zapisz22 = usun(tmp22, szukana);
                domek.setWanna(zapisz22);
                break;
            case "Wazony":
                String [] tmp23 = domek.getWazony().split(" ");
                String zapisz23 = usun(tmp23, szukana);
                domek.setWazony(zapisz23);
                break;
            case "Zlew":
                String [] tmp24 = domek.getZlew().split(" ");
                String zapisz24 = usun(tmp24, szukana);
                domek.setZlew(zapisz24);
                break;
        }
        domekService.update((String) sesja.getAttribute("login"), domek);
        return getDomek(sesja, model);
    }

    private String usun(String [] tmp, String szukana){
        String zapisz = "";
        for(int i=0; i<tmp.length; i++){
            if(tmp[i].equals(szukana)){
                tmp[i] = "";
            }
            zapisz = zapisz + tmp[i];
        }
        return zapisz;
    }
}
