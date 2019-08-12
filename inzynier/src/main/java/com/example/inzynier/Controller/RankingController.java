package com.example.inzynier.Controller;

import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.Service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

import javax.servlet.http.HttpSession;

@Controller
public class RankingController {
    @Autowired
    private UzytkownikService uzytkownikService;

    @GetMapping("/ranking")
    public ModelAndView getRanking(@RequestParam(required = false) Integer page, HttpSession sesja){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        List<UzytkownikDTO> uzytkownikList = uzytkownikService.listRaking();
        ModelAndView modelAndView = new ModelAndView("ranking.index","uzytkownikLista",uzytkownikList);
        PagedListHolder<UzytkownikDTO> pagedListHolder = new PagedListHolder<>(uzytkownikList); // tworzymy pagelistholder z nasza lista uzytkownikow
        pagedListHolder.setPageSize(20);
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
}
