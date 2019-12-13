package com.example.inzynier.Controller;

import com.example.inzynier.DTO.*;
import com.example.inzynier.Service.EkwipunekService;
import com.example.inzynier.Service.KuzniaService;
import com.example.inzynier.Service.UzytkownikService;
import com.example.inzynier.Service.ZbrojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ZbrojowniaController {

    @Autowired
    private UzytkownikService uzytkownikService;
    @Autowired
    private ZbrojaService zbrojaService;
    @Autowired
    private EkwipunekService ekwipunekService;
    @Autowired
    private KuzniaService kuzniaService;

    @GetMapping("/zbrojownia")
    public ModelAndView kupZbroje(@RequestParam(required = false)Integer page, HttpSession sesja, ModelMap modelMap){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        List<ZbrojaDTO> zbrojaDTO = zbrojaService.findAll();
        ModelAndView modelAndView = new ModelAndView("zbrojownia.index");
        modelMap.put("uzytkownik", uzytkownikService.findByLogin((String) sesja.getAttribute("login")));
        return createPagination(zbrojaDTO, modelAndView,page);
    }

    @PostMapping("/zbrojownia")
    public ModelAndView kupowanie(@RequestParam(required = false) Integer page, @RequestBody KupZbrojeDTO kupZbrojeDTO, HttpSession sesja, ModelMap modelMap){
        String login = (String) sesja.getAttribute("login");
        UzytkownikDTO uzytkownikDTO = uzytkownikService.findByLogin(login);
        uzytkownikDTO.setZloteMonety(uzytkownikDTO.getZloteMonety() - Integer.parseInt(kupZbrojeDTO.getCena()));
        uzytkownikService.update(uzytkownikDTO.getLogin(), uzytkownikDTO);
        ZbrojaDTO zbrojaDTO = zbrojaService.findByNazwa(kupZbrojeDTO.getNazwa());
        EkwipunekDTO ekwipunekDTO = new EkwipunekDTO(uzytkownikDTO, kupZbrojeDTO.getNazwa(), zbrojaDTO.getPlik(), zbrojaDTO.toString());
        ekwipunekService.create(ekwipunekDTO);
        return kupZbroje(page,sesja, modelMap);
    }

    @GetMapping("/licytujZbroje")
    public ModelAndView licytujZbroje(@RequestParam(required = false)Integer page, HttpSession sesja, ModelMap modelMap){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        List<KuzniaDTO> kuzniaDTO = kuzniaService.findAll();
        ModelAndView modelAndView = new ModelAndView("licytujZbroje.index", "licytuj", new LicytujDTO());
        modelMap.put("uzytkownik", uzytkownikService.findByLogin((String) sesja.getAttribute("login")));
        return createPaginationKuznia(kuzniaDTO, modelAndView, page);
    }
    @PostMapping(value = "/licytujZbroje/{index}", consumes = "multipart/form-data", produces = { "application/json", "application/xml" })
    public ModelAndView zalicytuj(@RequestParam(required = false)Integer page, @PathVariable("index") Integer index, @ModelAttribute("licytuj") LicytujDTO licytujDTO, HttpSession sesja, ModelMap modelMap){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        UzytkownikDTO uzytkownikDTO = uzytkownikService.findByLogin((String) sesja.getAttribute("login"));
        KuzniaDTO kuzniaDTO = kuzniaService.findById(index);
        if(licytujDTO.getCena() > uzytkownikDTO.getZloteMonety()){
            modelMap.put("error","Nie masz wystarczajacej ilosci pieniedzy!");
        }
        else if(licytujDTO.getCena() > kuzniaDTO.getAktualnaCena()){
            kuzniaDTO.setAktualnaCena(licytujDTO.getCena().floatValue());
            kuzniaDTO.setKupujacy((String) sesja.getAttribute("login"));
            kuzniaDTO.setIloscLicytujacych(kuzniaDTO.getIloscLicytujacych() + 1);
            kuzniaService.update(index, kuzniaDTO);
        }
        else modelMap.put("error","Podana przez Ciebie cena jest za mala!");
        return licytujZbroje(page,sesja,modelMap);
    }

    @GetMapping("/wystawZbroje")
    public ModelAndView wystawZbroje(HttpSession sesja, ModelMap modelMap){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        UzytkownikDTO uzytkownikDTO = uzytkownikService.findByLogin((String) sesja.getAttribute("login"));
        List<String> zbroja = new ArrayList<>();
        try{
            ekwipunekService.findByWlasciciel(uzytkownikDTO).forEach( it -> zbroja.add(it.getNazwa()));
            modelMap.put("mojeAukcje", kuzniaService.findBySprzedajacy(uzytkownikDTO));
            kuzniaService.findAll().forEach( it -> zbroja.remove(it.getNazwa()) );
        }
        catch (EntityNotFoundException e){
            modelMap.put("mojeAukcje", new ArrayList());
        }
        modelMap.put("mojaZbroja", zbroja);
        return new ModelAndView("wystawZbroje.index", "zbroja", new KupZbrojeDTO());
    }
    @PostMapping(value ="/wystawZbroje", consumes = "multipart/form-data", produces = { "application/json", "application/xml" })
    public ModelAndView sprzedaj(@ModelAttribute("zbroja") KupZbrojeDTO kupZbrojeDTO, HttpSession sesja, ModelMap modelMap){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        String login = (String) sesja.getAttribute("login");
        ZbrojaDTO zbrojaDTO = zbrojaService.findByNazwa(kupZbrojeDTO.getNazwa());
        KuzniaDTO kuzniaDTO = new KuzniaDTO(
                login,
                null,
                Float.parseFloat(kupZbrojeDTO.getCena()),
                false,
                0,
                zbrojaDTO.getNazwa(),
                zbrojaDTO.getPlik(),
                zbrojaDTO.getKlasa(),
                zbrojaDTO.toString(),
                LocalDateTime.now().plusDays(2));
        kuzniaService.create(kuzniaDTO);
        return wystawZbroje(sesja, modelMap);
    }
    @DeleteMapping("/wystawZbroje/{index}")
    public ModelAndView usunTranzakcje(@PathVariable("index") Integer index, HttpSession sesja, ModelMap modelMap){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        kuzniaService.delete(index);
        return wystawZbroje(sesja, modelMap);
    }

    private ModelAndView createPagination(List<ZbrojaDTO> zbrojaList, ModelAndView modelAndView, Integer page){
        PagedListHolder<ZbrojaDTO> pagedListHolder = new PagedListHolder<>(zbrojaList); // tworzymy pagelistholder z nasza lista uzytkownikow
        pagedListHolder.setPageSize(10);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount()); // znajdujemy maksymalna liczbe naszych uzytkownikow
        if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1; // w przypadku gdy nie rozpoznajemy strony wracamy n strone pierwsza
        modelAndView.addObject("page", page); // i dodajemy ja do naszego modelAndView
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            modelAndView.addObject("listaZbroja", pagedListHolder.getPageList());
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
            modelAndView.addObject("listaZbroja", pagedListHolder.getPageList());
        }
        return modelAndView;
    }
    private ModelAndView createPaginationKuznia(List<KuzniaDTO> kuzniaList, ModelAndView modelAndView, Integer page){
        PagedListHolder<KuzniaDTO> pagedListHolder = new PagedListHolder<>(kuzniaList); // tworzymy pagelistholder z nasza lista uzytkownikow
        pagedListHolder.setPageSize(10);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount()); // znajdujemy maksymalna liczbe naszych uzytkownikow
        if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1; // w przypadku gdy nie rozpoznajemy strony wracamy n strone pierwsza
        modelAndView.addObject("page", page); // i dodajemy ja do naszego modelAndView
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            modelAndView.addObject("listaKuznia", pagedListHolder.getPageList());
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
            modelAndView.addObject("listaKuznia", pagedListHolder.getPageList());
        }
        return modelAndView;
    }
}
