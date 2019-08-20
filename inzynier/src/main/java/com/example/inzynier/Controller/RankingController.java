package com.example.inzynier.Controller;

import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.Repositories.UzytkownikRepositories;
import com.example.inzynier.Service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;

@Controller
public class RankingController {
    @Autowired
    private UzytkownikService uzytkownikService;
    @Autowired
    private UzytkownikRepositories uzytkownikRepositories;

    @GetMapping("/ranking")
    public ModelAndView getRanking(@RequestParam(required = false) Integer page, HttpSession sesja, ModelMap modelMap){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        modelMap.put("search",new String());
        List<UzytkownikDTO> uzytkownikList = uzytkownikService.listRaking();
        ModelAndView modelAndView = new ModelAndView("ranking.index","uzytkownikLista",uzytkownikList);
        PagedListHolder<UzytkownikDTO> pagedListHolder = new PagedListHolder<>(uzytkownikList); // tworzymy pagelistholder z nasza lista uzytkownikow
        pagedListHolder.setPageSize(15);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount()); // znajdujemy maksymalna liczbe naszych uzytkownikow
        if(page==null || page < 1 || page > pagedListHolder.getPageCount()){
            String login = sesja.getAttribute("login").toString();
            modelMap.put("login",login);
            List<UzytkownikDTO> listTmp = uzytkownikService.listRaking();
            for(int i=0;i<listTmp.size();i++){
                if(listTmp.get(i).getLogin().equals(login)){
                    pagedListHolder.setPage((i/14)+1);
                    page = (i/14)+1;
                    break;
                }
                else{
                    pagedListHolder.setPage(1);
                    page = 1;
                }
            }
        }
        modelAndView.addObject("page", page); // i dodajemy ja do naszego modelAndView
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){ // w tym miejscu moge ustawic strone dla uzytkownika
            pagedListHolder.setPage(0);
            modelAndView.addObject("uzytkownikLista", pagedListHolder.getPageList());
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
            modelAndView.addObject("uzytkownikLista", pagedListHolder.getPageList());
        }
        return modelAndView;

    }
    @PostMapping("/search")
    public ModelAndView search(@RequestParam("search") String search, HttpSession sesja, ModelMap model){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        if(!uzytkownikRepositories.findByLogin(search).isPresent()){
            model.put("error","Nie ma uzytkownika z takim loginem");
            throw new EntityNotFoundException("Nie ma takiego uzytkownika");
        }
        List<UzytkownikDTO> listTmp = new ArrayList<>();
        listTmp.add(uzytkownikService.findByLogin(search));
        return new ModelAndView ("ranking.index", "uzytkownikLista", listTmp);
    }
}
