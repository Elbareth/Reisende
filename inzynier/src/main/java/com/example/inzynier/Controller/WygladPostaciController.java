package com.example.inzynier.Controller;

import com.example.inzynier.Assembler.WygladPostaciAssembler;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.DTO.WygladPostaciDTO;
import com.example.inzynier.Service.UzytkownikService;
import com.example.inzynier.Service.WygladPostaciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

import javax.servlet.http.HttpSession;

@Controller
public class WygladPostaciController {

    @Autowired
    private UzytkownikService uzytkownikService;

    @Autowired
    private WygladPostaciService wygladPostaciService;

    @Autowired
    private WygladPostaciAssembler wygladPostaciAssembler;

    @GetMapping("/wyglad")
    public ModelAndView getWygladPostaci(@RequestParam(required = false) Integer page, HttpSession sesja, ModelMap modelMap){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        List<WygladPostaciDTO> lista = wygladPostaciAssembler.toDto(wygladPostaciService.findAll());
        modelMap.put("lista",lista);
        UzytkownikDTO uzytkownikDTO = uzytkownikService.findByLogin((String) sesja.getAttribute("login"));
        ModelAndView modelAndView = new ModelAndView("wyglad.index", "lista", lista);
        PagedListHolder<WygladPostaciDTO> pagedListHolder = new PagedListHolder<>(lista); // tworzymy pagelistholder z nasza lista uzytkownikow
        pagedListHolder.setPageSize(1);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount()); // znajdujemy maksymalna liczbe naszych uzytkownikow
        if(page==null || page < 1 || page > pagedListHolder.getPageCount()){
            page = wygladPostaciService.findByNazwa(uzytkownikDTO.getWyglad()).getId();
            pagedListHolder.setPage(page);
            modelMap.put("current", wygladPostaciService.findById(page).getPlik());
        }
        modelAndView.addObject("page", page); // i dodajemy ja do naszego modelAndView
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){ // w tym miejscu moge ustawic strone dla uzytkownika
            pagedListHolder.setPage(0);
            modelAndView.addObject("lista", pagedListHolder.getPageList());
            modelMap.put("current", wygladPostaciService.findById(page).getPlik());
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
            modelAndView.addObject("lista", pagedListHolder.getPageList());
            modelMap.put("current", wygladPostaciService.findById(page).getPlik());
        }
        return modelAndView;
    }
    @PostMapping("/wyglad/save/{current}")
    public ModelAndView saveWyglad(@PathVariable("current") String plik, HttpSession sesja){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        UzytkownikDTO uzytkownikDTO = uzytkownikService.findByLogin((String) sesja.getAttribute("login"));
        uzytkownikDTO.setWyglad(wygladPostaciService.findByPlik(plik).getNazwa());
        uzytkownikService.update((String) sesja.getAttribute("login"), uzytkownikDTO);
        return getWygladPostaci(wygladPostaciService.findByPlik(plik).getId(),sesja, new ModelMap());
    }
    //TODO odbior dla zbroi
}
