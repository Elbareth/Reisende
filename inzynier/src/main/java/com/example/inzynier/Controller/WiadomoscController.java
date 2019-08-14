package com.example.inzynier.Controller;

import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.DTO.WiadomosciDTO;
import com.example.inzynier.Repositories.UzytkownikRepositories;
import com.example.inzynier.Service.UzytkownikService;
import com.example.inzynier.Service.WiadomosciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
public class WiadomoscController {
    @Autowired
    private WiadomosciService wiadomosciService;
    @Autowired
    private UzytkownikService uzytkownikService;
    @Autowired
    private UzytkownikRepositories uzytkownikRepositories;

    @GetMapping("/wiadomosc")
    public ModelAndView getListaOdbiorca(@RequestParam(required = false) Integer page, HttpSession sesja){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        final UzytkownikDTO uzytkownikTmp = uzytkownikService.findByLogin(sesja.getAttribute("login").toString());
        List<WiadomosciDTO> wiadomosciList = wiadomosciService.findByOdbiorca(uzytkownikTmp);
        ModelAndView modelAndView = new ModelAndView("wiadomosci.index","wiadomosciList",wiadomosciList);
        return createPagination(wiadomosciList, modelAndView, page);
    }

    @GetMapping("/wiadomosciNadawca")
    public ModelAndView getListNadawca(@RequestParam(required = false) Integer page, HttpSession sesja){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        final UzytkownikDTO uzytkownikTmp = uzytkownikService.findByLogin(sesja.getAttribute("login").toString());
        List<WiadomosciDTO> wiadomosciList = wiadomosciService.findByNadawca(uzytkownikTmp);
        ModelAndView modelAndView = new ModelAndView("wiadomosciNadawca.index","wiadomosciList",wiadomosciList);
        return createPagination(wiadomosciList, modelAndView, page);
    }

    @GetMapping("/otworz/{id}")
    public ModelAndView getWiadomosc(@PathVariable("id") Integer id, HttpSession sesja){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        final WiadomosciDTO wiadomosciDTO = wiadomosciService.findById(id);
        return new ModelAndView("otworzWiadomosc.index", "wiadomosc",wiadomosciDTO);
    }

    @PostMapping("/delete/{typ}/{id}")
    public ModelAndView deleteWindow(@PathVariable("id") Integer id,@PathVariable("typ") String typ, HttpSession sesja){
        wiadomosciService.deleteWiadomosc(id);
        if(typ.equals("nadawca")) return getListNadawca(1,sesja);
        return getListaOdbiorca(1,sesja);
    }

    @GetMapping("/napiszWiadomosc")
    public ModelAndView napiszWiadomosc(HttpSession sesja){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        return new ModelAndView("napiszWiadomosc.index","wiadomosc",new WiadomosciDTO());
    }
    @PostMapping("/wyslijWiadomosc")
    public ModelAndView wyslijWiadomosc(@ModelAttribute("wiadomosc")WiadomosciDTO wiadomosc, HttpSession sesja){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        if(!uzytkownikRepositories.findByLogin(wiadomosc.getOdbiorca()).isPresent()){
            //TODO Alert
            return new ModelAndView("napiszWiadomosc.index","wiadomosc",new WiadomosciDTO());
        }
        basicInfoForMessage(wiadomosc, (String) sesja.getAttribute("login"), sesja);
        return getListaOdbiorca(1,sesja);
    }

    @GetMapping("/odpiszWiadomosc/{odbiorca}")
    public ModelAndView odpiszWiadomosc(@PathVariable("odbiorca") String odbiorca, HttpSession sesja, ModelMap modelMap){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        WiadomosciDTO wiadomosciDTO = new WiadomosciDTO();
        wiadomosciDTO.setOdbiorca(odbiorca);
        modelMap.put("wiadomoscTmp",wiadomosciDTO);
        return new ModelAndView("odpiszNaWiadomosc.index","wiadomosc",wiadomosciDTO);
    }

    @PostMapping(value = "/wyslijRE/{odbiorca}", consumes = "multipart/form-data", produces = { "application/json", "application/xml" })
    public ModelAndView wyslijRE(@PathVariable("odbiorca") String odbiorca, @ModelAttribute("wiadomosc") WiadomosciDTO wiadomosc, HttpSession sesja){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        if(!uzytkownikRepositories.findByLogin(odbiorca).isPresent()){
            //TODO Alert
            return new ModelAndView("napiszWiadomosc.index","wiadomosc",new WiadomosciDTO());
        }
        basicInfoForMessage(wiadomosc, odbiorca, sesja);
        return getListaOdbiorca(1,sesja);
    }

    private ModelAndView createPagination(List<WiadomosciDTO> wiadomosciList, ModelAndView modelAndView, Integer page){
        PagedListHolder<WiadomosciDTO> pagedListHolder = new PagedListHolder<>(wiadomosciList); // tworzymy pagelistholder z nasza lista uzytkownikow
        pagedListHolder.setPageSize(15);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount()); // znajdujemy maksymalna liczbe naszych uzytkownikow
        if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1; // w przypadku gdy nie rozpoznajemy strony wracamy n strone pierwsza
        modelAndView.addObject("page", page); // i dodajemy ja do naszego modelAndView
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            modelAndView.addObject("uzytkownikLista", pagedListHolder.getPageList());
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
            modelAndView.addObject("uzytkownikLista", pagedListHolder.getPageList());
        }
        return modelAndView;
    }
    public void basicInfoForMessage(WiadomosciDTO wiadomosc, String odbiorca, HttpSession sesja){
        wiadomosc.setOdbiorca(odbiorca);
        String login = sesja.getAttribute("login").toString();
        wiadomosc.setNadawca(login);
        wiadomosc.setData(LocalDate.now());
        wiadomosciService.createWiadomosc(wiadomosc);
    }
}
