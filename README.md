# Reisende
Gra którą piszę na moją pracę licencjacką
package com.example.inzynier.Service;

import com.example.inzynier.Assembler.UzytkownikAssembler;
import com.example.inzynier.Assembler.WiadomosciAssembler;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.DTO.WiadomosciDTO;
import com.example.inzynier.Repositories.WiadomosciRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WiadomosciService {
    @Autowired
    private WiadomosciRepositories wiadomosciRepositories;
    @Autowired
    private UzytkownikAssembler uzytkownikAssembler;
    @Autowired
    private WiadomosciAssembler wiadomosciAssembler;
    //wyszukiwaie po nadawcy po odbiorcy i po id
    //dodawanie usuwanie ale brak modyfikacji
    public List<WiadomosciDTO> getNadawca(UzytkownikDTO nadawca){
        return wiadomosciAssembler.toDto(wiadomosciRepositories.findAllByNadawcaOrderByDataAsc(uzytkownikAssembler.toEntity(nadawca)));
    }
    public List<WiadomosciDTO> getOdbiorca(UzytkownikDTO odbiorca){
        return wiadomosciAssembler.toDto(wiadomosciRepositories.findAllByOdbiorcaOrderByDataAsc(uzytkownikAssembler.toEntity(odbiorca)));
    }
    public WiadomosciDTO getById(Integer id){
        return wiadomosciAssembler.toDto(wiadomosciRepositories.findById(id).get());
    }
    public WiadomosciDTO createWiadomosc(WiadomosciDTO wiadomosciDTO){
        return wiadomosciAssembler.toDto(wiadomosciRepositories.save(wiadomosciAssembler.toEntity(wiadomosciDTO)));
    }
    public void deleteWiadomosc(Integer id){
        wiadomosciRepositories.deleteById(id);
    }
}

package com.example.inzynier.Controller;

import com.example.inzynier.Assembler.UzytkownikAssembler;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.DTO.WiadomosciDTO;
import com.example.inzynier.Repositories.UzytkownikRepositories;
import com.example.inzynier.Service.UzytkownikService;
import com.example.inzynier.Service.WiadomosciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

@Controller
public class WiadomosciController {
    @Autowired
    private WiadomosciService wiadomosciService;
    @Autowired
    private UzytkownikService uzytkownikService;
    @Autowired
    private UzytkownikAssembler uzytkownikAssembler;
    @Autowired
    private UzytkownikRepositories uzytkownikRepositories;
    @GetMapping("/wiadomoscNadawca/{page}")
    public ModelAndView nadawca(HttpSession sesja, @PathVariable("page")String page){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        String login = sesja.getAttribute("login").toString();
        List<WiadomosciDTO> wiadomosc = wiadomosciService.getNadawca(uzytkownikService.findByLogin(login));
        PagedListHolder<WiadomosciDTO> pagination = pagination(page, wiadomosc, sesja);
        ModelMap modelMap = new ModelMap("listaWiadomosci",pagination);
        return new ModelAndView("wiadomoscNadawca.index","wiadomosc",wiadomosc);
    }
    @GetMapping("/wiadomoscOdbiorca/{page}")
    public ModelAndView odbiorca(HttpSession sesja, @PathVariable("page")String page){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        String login = sesja.getAttribute("login").toString();
        List<WiadomosciDTO> wiadomosc = wiadomosciService.getOdbiorca(uzytkownikService.findByLogin(login));
        PagedListHolder<WiadomosciDTO> pagination = pagination(page, wiadomosc, sesja);
        ModelMap modelMap = new ModelMap("listaWiadomosci",pagination);
        return new ModelAndView("wiadomoscOdbiorca.index","wiadomosc",wiadomosc);
    }
    @GetMapping("/napiszWiadomosc")
    public ModelAndView napiszWiadomosc(HttpSession sesja){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        WiadomosciDTO wiadomosciDTO = new WiadomosciDTO();
        wiadomosciDTO.setData(LocalDate.now());
        String login = sesja.getAttribute("login").toString();
        wiadomosciDTO.setNadawca(login);
        return new ModelAndView("wiadomoscNapisz.index","wiadomosc",wiadomosciDTO);
    }
    @PostMapping("/wyslijWiadomosc")
    public ModelAndView wyslijWiadomosc(@ModelAttribute("wiadomosc")WiadomosciDTO wiadomosc, HttpSession sesja){
        if(sesja.getAttribute("login")==null){
            return new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        }
        if(!uzytkownikRepositories.findByLogin(wiadomosc.getOdbiorca()).isPresent()){
            //JOptionPane.showMessageDialog(null,"Podany odbiorca nie istnieje. Wybierz innego");
            //FacesContext.getCurrentInstance().addMessage("Podany odbiorca nie istnieje. Wybierz innego",);
            //TODO Alert
            return new ModelAndView("wiadomoscNapisz.index","wiadomosc",new WiadomosciDTO());
        }
        String login = sesja.getAttribute("login").toString();
        wiadomosc.setNadawca(login);
        wiadomosc.setData(LocalDate.now());
        wiadomosciService.createWiadomosc(wiadomosc);
        return new ModelAndView("wiadomoscOdbiorca.index","wiadomosc",wiadomosc);
    }
//    @GetMapping("/wiadomosc/{id}")
//    public ModelAndView zwrocWiadomosc(){
//        //TODO
//    }
    //TODO odpowiadanie na wiadomosci
    PagedListHolder<WiadomosciDTO> pagination(String page, List<WiadomosciDTO> wiadomosc, HttpSession sesja){
        PagedListHolder<WiadomosciDTO> listWiadomosci;
        if(page == null){
            listWiadomosci = new PagedListHolder<>();
            listWiadomosci.setSource(wiadomosc);
            listWiadomosci.setPageSize(20);
            sesja.setAttribute("page",listWiadomosci);
        }
        else if(page.equals("prev")){
           listWiadomosci = (PagedListHolder<WiadomosciDTO>) sesja.getAttribute("page");
            if(listWiadomosci == null){
                int pageNumber;
                try{
                    pageNumber = Integer.parseInt(page);
                }
                catch(Exception e){
                    pageNumber = 1;
                }
                listWiadomosci = new PagedListHolder<>();
                if(pageNumber == 0 || pageNumber == 1) listWiadomosci.setPage(1);
            }
           listWiadomosci.previousPage();
        }
        else if(page.equals("next")){
            listWiadomosci = (PagedListHolder<WiadomosciDTO>) sesja.getAttribute("page");
            if(listWiadomosci == null){
                int pageNumber;
                try{
                    pageNumber = Integer.parseInt(page);
                }
                catch(Exception e){
                    pageNumber = 1;
                }
                listWiadomosci = new PagedListHolder<>();
                if(pageNumber == 0 || pageNumber == 1) listWiadomosci.setPage(1);
            }
            listWiadomosci.nextPage();
        }
        else{
            int pageNumber = Integer.parseInt(page);
            listWiadomosci = (PagedListHolder<WiadomosciDTO>) sesja.getAttribute("page");
            if(listWiadomosci == null ) listWiadomosci = new PagedListHolder<>();
            if(pageNumber == 0 || pageNumber == 1) listWiadomosci.setPage(1);
            else listWiadomosci.setPage(pageNumber-1);
        }
        return listWiadomosci;
    }
}

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<body>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Parisienne&display=swap');
    </style>
    <div class="main">
        <h1> Reisende - Napisz wiadomosc </h1>
        <a href="/wiadomoscOdbiorca/1"><input type="submit" value="Wiadomosci Odebrane"> <img src="/resources/raport.png"/></input></a>
        <a href="/wiadomoscNadawca/1"><input type="submit" value="Wiadomosci Wyslane"> <img src="/resources/raport.png"/></input></a>
        <a href="/napiszWiadomosc"><input type="submit" value="Napisz wiadomosc"> <img src="/resources/pioro.png"/></input></a>
        <div class="letter">
            <s:form action="/wyslijWiadomosc" method="post" modelAttribute="wiadomosc" enctype="multipart/form-data">
                <div class="innerLetter">
                    <h3>Odbiorca:</h3><s:input required = "required" placeholder = "Do kogo chcesz napisac list?" path = "odbiorca"/><br/>
                    <h3>Tytul:</h3><s:input required = "required" placeholder = "Wprowadz tytul" path = "tytul"/><br/>
                    <h3>Tresc:</h3><form:textarea path="tresc" maxlength="1000" rows="10" cols="50"/>
                    <br/><br/>
                <input type="submit" value="Wyslij"/></br>
                <br/><br/><br/>
                </div>
            </s:form>
        </div>
    </div>
</body>


