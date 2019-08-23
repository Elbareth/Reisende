package com.example.inzynier.Controller;

import com.example.inzynier.Assembler.WiadomosciAssembler;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.DTO.WiadomosciDTO;
import com.example.inzynier.Repositories.UzytkownikRepositories;
import com.example.inzynier.Repositories.WiadomosciRepositories;
import com.example.inzynier.tables.Uzytkownik;
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
import javax.transaction.Transactional;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class WiadomoscControllerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private WiadomoscController wiadomoscController;

    @Autowired
    private WiadomosciRepositories wiadomosciRepositories;

    @Autowired
    private WiadomosciAssembler wiadomosciAssembler;

    @Autowired
    private UzytkownikRepositories uzytkownikRepositories;

    @Autowired
    private HttpSession sesja;

    private WiadomosciDTO wiadomosciDTO;

    @Before
    public void init(){
        sesja.setAttribute("login", "Admin");
        wiadomosciDTO = new WiadomosciDTO("Admin","Admin","Tytul","...", LocalDate.of(2017,7,2));
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void getListaOdbiorca() {
        ModelAndView model = new ModelAndView("wiadomosci.index");
        model.addObject("maxPages",wiadomosciRepositories.findAllByOdbiorcaOrderByDataDesc(uzytkownikRepositories.findByLogin("Admin").get()).size()/11+1);
        model.addObject("page",1);
        model.addObject("wiadomosciList",wiadomosciAssembler.toDtoWithId(wiadomosciRepositories.findAllByOdbiorcaOrderByDataDesc(uzytkownikRepositories.findByLogin("Admin").get())).subList(0,10));
        Assertions.assertThat(wiadomoscController.getListaOdbiorca(1,sesja).toString()).isEqualTo(model.toString());
    }

    @Test
    public void getListaOdbiorcaRedirect() {
        try{
            sesja.setAttribute("login", null);
            Assertions.assertThat(
                    wiadomoscController
                            .getListaOdbiorca(1, sesja)
                            .toString()
            )
                    .isEqualTo(
                            new ModelAndView("login","uzytkownik",new UzytkownikDTO()
                            ).toString());
        }
        catch(EntityNotFoundException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("There is no user with this login");
        }
    }

    @Test
    public void getListNadawca() {
        ModelAndView model = new ModelAndView("wiadomosciNadawca.index");
        Uzytkownik tmp = uzytkownikRepositories.findByLogin("Admin").get();
        model.addObject("maxPages",wiadomosciRepositories.findAllByNadawcaOrderByDataDesc(tmp).size()/11+1);
        model.addObject("page",1);
        model.addObject("wiadomosciList", wiadomosciAssembler.toDtoWithId(wiadomosciRepositories.findAllByNadawcaOrderByDataDesc(tmp)).subList(0,10));
        Assertions.assertThat(wiadomoscController.getListNadawca(1,sesja).toString()).isEqualTo(model.toString());
    }

    @Test
    public void getListNadawcaRedirect() {
        try{
            sesja.setAttribute("login", null);
            Assertions.assertThat(
                    wiadomoscController
                            .getListNadawca(1, sesja)
                            .toString()
            )
                    .isEqualTo(
                            new ModelAndView("login","uzytkownik",new UzytkownikDTO()
                            ).toString());
        }
        catch(EntityNotFoundException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("There is no user with this login");
        }
    }

    @Test
    public void getWiadomosc() {
        Assertions.assertThat(
                wiadomoscController
                        .getWiadomosc(1,sesja)
                        .toString()
        )
                .isEqualTo(
                        new ModelAndView(
                                "otworzWiadomosc.index",
                                "wiadomosc",
                                wiadomosciAssembler.toDtoWithId(
                                        wiadomosciRepositories.findById(1)
                                                .get()
                                )
                        ).toString()
                );
    }

    @Test
    public void getWiadomoscRedirect() {
        try{
            sesja.setAttribute("login", null);
            Assertions.assertThat(
                    wiadomoscController
                            .getWiadomosc(1, sesja)
                            .toString()
            )
                    .isEqualTo(
                            new ModelAndView("login","uzytkownik",new UzytkownikDTO()
                            ).toString());
        }
        catch(EntityNotFoundException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("There is no user with this login");
        }
    }

    @Test
    public void deleteWindowNadawca() {
        int size = wiadomosciRepositories.findAll().size();
        wiadomoscController.deleteWindow(1,"nadawca",sesja);
        Assertions.assertThat(size-1).isEqualTo(wiadomosciRepositories.findAll().size());
    }

    @Test
    public void deleteWindowOdbiorca() {
        int size = wiadomosciRepositories.findAll().size();
        wiadomoscController.deleteWindow(1,"odbiorca",sesja);
        Assertions.assertThat(size-1).isEqualTo(wiadomosciRepositories.findAll().size());
    }

    @Test
    public void napiszWiadomosc() {
        Assertions.assertThat(
                wiadomoscController
                        .napiszWiadomosc(sesja)
                        .toString()
        )
                .isEqualTo(
                        new ModelAndView(
                                "napiszWiadomosc.index",
                                "wiadomosc",
                                new WiadomosciDTO()
                        )
                                .toString()
                );
    }

    @Test
    public void napiszWiadomoscRedirect() {
        try{
            sesja.setAttribute("login", null);
            Assertions.assertThat(
                    wiadomoscController
                            .napiszWiadomosc(sesja)
                            .toString()
            )
                    .isEqualTo(
                            new ModelAndView("login","uzytkownik",new UzytkownikDTO()
                            ).toString());
        }
        catch(EntityNotFoundException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("There is no user with this login");
        }
    }

    @Test
    public void wyslijWiadomosc() {
        ModelAndView model = new ModelAndView("wiadomosci.index");
        model.addObject("maxPages",wiadomosciRepositories.findAllByOdbiorcaOrderByDataDesc(uzytkownikRepositories.findByLogin("Admin").get()).size()/11+1);
        model.addObject("page",1);
        model.addObject("wiadomosciList",wiadomosciAssembler.toDtoWithId(wiadomosciRepositories.findAllByOdbiorcaOrderByDataDesc(uzytkownikRepositories.findByLogin("Admin").get())).subList(0,10));
        Assertions.assertThat(
                wiadomoscController
                        .wyslijWiadomosc(wiadomosciDTO, sesja, new ModelMap())
                        .toString()
        )
                .isEqualTo(
                        model
                        .toString());
    }

    @Test
    public void wyslijWiadomoscRedirect() {
        try{
            sesja.setAttribute("login", null);
            Assertions.assertThat(
                    wiadomoscController
                            .wyslijWiadomosc(wiadomosciDTO, sesja, new ModelMap())
                            .toString()
            )
                    .isEqualTo(
                            new ModelAndView("login","uzytkownik",new UzytkownikDTO()
                            ).toString());
        }
        catch(EntityNotFoundException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("There is no user with this login");
        }
    }

    @Test
    public void wyslijWiadomoscNotExist() {
        wiadomosciDTO.setOdbiorca("XXXX");
        try{
            sesja.setAttribute("login", null);
            Assertions.assertThat(
                    wiadomoscController
                            .wyslijWiadomosc(wiadomosciDTO, sesja, new ModelMap())
                            .toString()
            )
                    .isEqualTo(
                            new ModelAndView("login","uzytkownik",new UzytkownikDTO()
                            ).toString());
        }
        catch(EntityNotFoundException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("Odbiorca nie istnieje");
        }
    }

    @Test
    public void odpiszWiadomosc() {
        WiadomosciDTO wiad = new WiadomosciDTO();
        wiad.setOdbiorca("Admin");
        Assertions.assertThat(
                wiadomoscController
                        .odpiszWiadomosc("Admin", sesja, new ModelMap())
                        .toString()
        )
                .isEqualTo(
                        new ModelAndView("odpiszNaWiadomosc.index","wiadomosc",wiad)
                        .toString());
    }

    @Test
    public void odpiszWiadomoscRedirect() {
        try{
            sesja.setAttribute("login", null);
            Assertions.assertThat(
                    wiadomoscController
                            .odpiszWiadomosc("Admin", sesja, new ModelMap())
                            .toString()
            )
                    .isEqualTo(
                            new ModelAndView("login","uzytkownik",new UzytkownikDTO()
                            ).toString());
        }
        catch(EntityNotFoundException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("There is no user with this login");
        }
    }

    @Test
    public void odpiszWiadomoscNotExist() {
        try{
            sesja.setAttribute("login", null);
            Assertions.assertThat(
                    wiadomoscController
                            .odpiszWiadomosc("XXXX", sesja, new ModelMap())
                            .toString()
            )
                    .isEqualTo(
                            new ModelAndView("login","uzytkownik",new UzytkownikDTO()
                            ).toString());
        }
        catch(EntityNotFoundException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("Odbiorca nie istnieje");
        }
    }

    @Test
    public void wyslijRE() {
        ModelAndView model = new ModelAndView("wiadomosci.index");
        model.addObject("maxPages",wiadomosciRepositories.findAllByOdbiorcaOrderByDataDesc(uzytkownikRepositories.findByLogin("Admin").get()).size()/11+1);
        model.addObject("page",1);
        model.addObject("wiadomosciList",wiadomosciAssembler.toDtoWithId(wiadomosciRepositories.findAllByOdbiorcaOrderByDataDesc(uzytkownikRepositories.findByLogin("Admin").get())).subList(0,10));
        Assertions.assertThat(
                wiadomoscController
                        .wyslijRE("Admin", wiadomosciDTO, sesja, new ModelMap())
                        .toString()
        )
                .isEqualTo(
                        model.toString());
    }

    @Test
    public void wyslijRERedirect() {
        try{
            sesja.setAttribute("login", null);
            Assertions.assertThat(
                    wiadomoscController
                            .wyslijRE("Admin", wiadomosciDTO, sesja, new ModelMap())
                            .toString()
            )
                    .isEqualTo(
                            new ModelAndView("login","uzytkownik",new UzytkownikDTO()
                            ).toString());
        }
        catch(EntityNotFoundException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("There is no user with this login");
        }
    }

    @Test
    public void wyslijRENotExist() {
        try{
            sesja.setAttribute("login", null);
            Assertions.assertThat(
                    wiadomoscController
                            .wyslijRE("XXXX", wiadomosciDTO, sesja, new ModelMap())
                            .toString()
            )
                    .isEqualTo(
                            new ModelAndView("login","uzytkownik",new UzytkownikDTO()
                            ).toString());
        }
        catch(EntityNotFoundException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("Odbiorca nie istnieje");
        }
    }
}