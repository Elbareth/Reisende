package com.example.inzynier.Controller;

import com.example.inzynier.DTO.*;
import com.example.inzynier.Service.DomekService;
import org.assertj.core.api.Assertions;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DomekControllerTest {

    @Autowired
    private DomekController domekController;
    @Autowired
    private DomekService domekService;
    @Autowired
    private Flyway flyway;
    @Autowired
    private HttpSession sesja;
    private KupowanieMebliDTO kupowanieMebliDTO;
    private PrzenoszenieMebliDTO przenoszenieMebliDTO;
    private UsunMebelDTO usunMebelDTO;

    @Before
    public void init(){
        sesja.setAttribute("login", "Admin");
        kupowanieMebliDTO = new KupowanieMebliDTO("233","123","20","http://localhost:8080/resources/artDecoStol.png");
        przenoszenieMebliDTO = new PrzenoszenieMebliDTO("100", "5", "250", "250", "http://localhost:8080/resources/bialeOkno.png");
        usunMebelDTO = new UsunMebelDTO("232", "123", "http://localhost:8080/resources/artDecoStol.png");
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void getDomek() {
        DomekDTO domek = domekService.findByWlasciciel((String) sesja.getAttribute("login"));
        ModelAndView modelAndView =  new ModelAndView("dom.index", "domek", domek);
        Assertions.assertThat(domekController.getDomek(sesja, new ModelMap()).toString()).isEqualTo(modelAndView.toString());

    }

    @Test
    public void getDomekCantLogin() {
        sesja.setAttribute("login",null);
        ModelAndView modelAndView =  new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        Assertions.assertThat(domekController.getDomek(sesja, new ModelMap()).toString()).isEqualTo(modelAndView.toString());

    }

    @Test
    public void kupMebel() {
        DomekDTO domek = domekService.findByWlasciciel((String) sesja.getAttribute("login"));
        ModelAndView modelAndView =  new ModelAndView("dom.index", "domek", domek);
        Assertions.assertThat(domekController.kupMebel(kupowanieMebliDTO,sesja, new ModelMap()).toString()).isEqualTo(modelAndView.toString());
    }

    @Test
    public void kupMebelCantLogin() {
        sesja.setAttribute("login",null);
        ModelAndView modelAndView =  new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        Assertions.assertThat(domekController.kupMebel(kupowanieMebliDTO, sesja, new ModelMap()).toString()).isEqualTo(modelAndView.toString());
    }

    @Test
    public void updateMeble() {
        DomekDTO domek = domekService.findByWlasciciel((String) sesja.getAttribute("login"));
        domek.setOkna("BialeOkno-250x250");
        ModelAndView modelAndView =  new ModelAndView("dom.index", "domek", domek);
        Assertions.assertThat(domekController.updateMeble(przenoszenieMebliDTO,sesja, new ModelMap()).toString()).isEqualTo(modelAndView.toString());
    }

    @Test
    public void updateMebleCantLogin() {
        sesja.setAttribute("login",null);
        ModelAndView modelAndView =  new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        Assertions.assertThat(domekController.updateMeble(przenoszenieMebliDTO, sesja, new ModelMap()).toString()).isEqualTo(modelAndView.toString());
    }

    @Test
    public void usuwanieMebli() {
        DomekDTO domek = domekService.findByWlasciciel((String) sesja.getAttribute("login"));
        ModelAndView modelAndView =  new ModelAndView("dom.index", "domek", domek);
        Assertions.assertThat(domekController.usuwanieMebli(usunMebelDTO,sesja, new ModelMap()).toString()).isEqualTo(modelAndView.toString());
    }

    @Test
    public void usuwanieMebliCantLogin() {
        sesja.setAttribute("login",null);
        ModelAndView modelAndView =  new ModelAndView("login","uzytkownik",new UzytkownikDTO());
        Assertions.assertThat(domekController.usuwanieMebli(usunMebelDTO, sesja, new ModelMap()).toString()).isEqualTo(modelAndView.toString());
    }
}