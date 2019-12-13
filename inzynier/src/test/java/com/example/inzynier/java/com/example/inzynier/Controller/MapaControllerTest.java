package com.example.inzynier.java.com.example.inzynier.Controller;

import com.example.inzynier.Controller.MapaController;
import com.example.inzynier.DTO.Postac;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.Service.UzytkownikService;
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

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapaControllerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private MapaController mapaController;

    @Autowired
    private HttpSession sesja;

    @Autowired
    private UzytkownikService uzytkownikService;

    @Before
    public void init(){
        sesja.setAttribute("login","Admin");
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void mapa() {
        Assertions.assertThat(
                mapaController.mapa(
                        sesja,
                        new ModelMap()).toString())
                .isEqualTo(
                        new ModelAndView(
                                "mapa.index",
                                "uzytkownik",
                                uzytkownikService.findByLogin((String) sesja.getAttribute("login"))).toString());
    }

    @Test
    public void mapaRedirect() {
        try{
            sesja.setAttribute("login","XXX");
            Assertions.assertThat(
                    mapaController.mapa(
                            sesja,
                            new ModelMap()).toString())
                    .isEqualTo(
                            new ModelAndView(
                                    "login",
                                    "uzytkownik",
                                    new UzytkownikDTO()).toString());
        }
        catch(EntityNotFoundException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("There is no user with this login");
        }
    }

    @Test
    public void aktualizuj() {
        Assertions.assertThat(
                mapaController.aktualizuj(
                        sesja,
                        new ModelMap(),
                        new Postac("tlo6.jpg","2","5")).toString())
                .isEqualTo(
                        new ModelAndView(
                                "mapa.index",
                                "uzytkownik",
                                uzytkownikService.findByLogin((String) sesja.getAttribute("login"))).toString());
    }

    @Test
    public void aktualizujRedirect() {
        try{
            sesja.setAttribute("login","XXX");
            Assertions.assertThat(
                    mapaController.aktualizuj(
                            sesja,
                            new ModelMap(),
                            new Postac("tlo6.jpg","2","5")).toString())
                    .isEqualTo(
                            new ModelAndView(
                                    "login",
                                    "uzytkownik",
                                    new UzytkownikDTO()).toString());
        }
        catch(EntityNotFoundException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("There is no user with this login");
        }
    }
}