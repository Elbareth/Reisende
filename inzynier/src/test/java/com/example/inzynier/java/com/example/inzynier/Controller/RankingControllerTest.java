package com.example.inzynier.Controller;

import com.example.inzynier.Assembler.UzytkownikAssembler;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.Repositories.UzytkownikRepositories;
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
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RankingControllerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private RankingController rankingController;

    @Autowired
    private UzytkownikRepositories uzytkownikRepositories;

    @Autowired
    private UzytkownikAssembler uzytkownikAssembler;

    @Autowired
    private HttpSession sesja;

    @Before
    public void init(){
        sesja.setAttribute("login","Admin");
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void getRanking() {
        ModelAndView model = new ModelAndView(
                "ranking.index",
                "uzytkownikLista",
                uzytkownikAssembler.toDto(
                        uzytkownikRepositories.findAll().subList(15,21)));
        model.addObject("maxPages", (int) uzytkownikRepositories.findAll().size()/15 + 1);
        model.addObject("page", 2); // i dodajemy ja do naszego modelAndView
        Assertions.assertThat(
                rankingController.getRanking(
                        2,
                        sesja,
                        new ModelMap()).toString())
                .isEqualTo(model.toString());
    }

    @Test
    public void getRankingPageNullFirst() {
        ModelAndView model = new ModelAndView(
                "ranking.index",
                "uzytkownikLista",
                uzytkownikAssembler.toDto(
                        uzytkownikRepositories.findAll().subList(0,15)));
        model.addObject("maxPages", (int) uzytkownikRepositories.findAll().size()/15 + 1);
        model.addObject("page", 1); // i dodajemy ja do naszego modelAndView
        Assertions.assertThat(
                rankingController.getRanking(
                        null,
                        sesja,
                        new ModelMap()).toString())
                .isEqualTo(model.toString());
    }

    @Test
    public void getRankingPageNullSecond() {
        sesja.setAttribute("login","Admin9");
        ModelAndView model = new ModelAndView(
                "ranking.index",
                "uzytkownikLista",
                uzytkownikAssembler.toDto(
                        uzytkownikRepositories.findAll().subList(15,21)));
        model.addObject("maxPages", (int) uzytkownikRepositories.findAll().size()/15 + 1);
        model.addObject("page", 2); // i dodajemy ja do naszego modelAndView
        Assertions.assertThat(
                rankingController.getRanking(
                        null,
                        sesja,
                        new ModelMap()).toString())
                .isEqualTo(model.toString());
    }

    @Test
    public void getRankingRedirected() {
        sesja.setAttribute("login",null);
        try{
            Assertions.assertThat(
                    rankingController.getRanking(
                            null,
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
    public void search() {
        List<UzytkownikDTO> tmp = new ArrayList<>();
        tmp.add(uzytkownikAssembler.toDto(uzytkownikRepositories.findByLogin("Admin").get()));
        Assertions.assertThat(
                rankingController.search(
                        "Admin",
                        sesja,
                        new ModelMap()).toString())
                .isEqualTo(
                        new ModelAndView (
                                "ranking.index",
                                "uzytkownikLista",
                                tmp).toString());
    }

    @Test
    public void searchNoExist() {
        sesja.setAttribute("login","XXX");
        try{
            Assertions.assertThat(
                    rankingController.search(
                            null,
                            sesja,
                            new ModelMap()).toString())
                    .isEqualTo(
                            new ModelAndView(
                                    "login",
                                    "uzytkownik",
                                    new UzytkownikDTO()).toString());
        }
        catch(EntityNotFoundException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("Nie ma takiego uzytkownika");
        }
    }

    @Test
    public void searchRedirected() {
        sesja.setAttribute("login",null);
        try{
            Assertions.assertThat(
                    rankingController.search(
                            null,
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
}