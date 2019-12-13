package com.example.inzynier.java.com.example.inzynier.Controller;

import com.example.inzynier.Controller.WylogujController;
import com.example.inzynier.DTO.UzytkownikDTO;
import org.assertj.core.api.Assertions;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WylogujControllerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private WylogujController wylogujController;

    @Autowired
    private HttpSession sesja;
    @Before
    public void init(){
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void wyloguj() {
        Assertions.assertThat(
                wylogujController
                        .wyloguj(sesja)
                        .toString()
        )
                .isEqualTo(
                        new ModelAndView(
                                "login",
                                "uzytkownik",
                                new UzytkownikDTO()
                        )
                                .toString()
                );
    }

    @Test
    public void wylogujRedirect() {
        try{
            sesja.setAttribute("login",null);
            wylogujController.wyloguj(sesja).toString();
        }
        catch(EntityNotFoundException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("There is no user with this id");
        }
    }
}