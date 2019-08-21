package com.example.inzynier.Controller;

import com.example.inzynier.DTO.UzytkownikDTO;
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
public class LoginControllerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private LoginController loginController;

    @Autowired
    private HttpSession sesja;

    private UzytkownikDTO uzytkownikDTO;

    @Before
    public void init(){
        uzytkownikDTO = new UzytkownikDTO(
                "Admin",
                "Admin",
                "Admin",
                "Mag",
                100,
                0,
                "Szatyn Wojownik",
                'K',
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                "brak",
                "brak",
                "brak",
                "brak",
                "brak",
                "brak",
                "brak",
                100,
                100,
                100,
                100,
                "brak",
                1,
                "1x1");
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void showMainPage() {
        Assertions.assertThat(loginController.showMainPage().toString()).isEqualTo(new ModelAndView("login", "uzytkownik", new UzytkownikDTO()).toString());
    }

    @Test
    public void logowanie() {
        ModelMap model = new ModelMap();
        model.put("uzytkownik",new UzytkownikDTO());
        Assertions.assertThat(loginController.logowanie(uzytkownikDTO, sesja, new ModelMap()).toString()).isEqualTo(new ModelAndView("redirect:/maps", model).toString());
    }

    @Test
    public void logowanieError() {
        uzytkownikDTO.setLogin("AdminX");
        Assertions.assertThat(loginController.logowanie(uzytkownikDTO, sesja, new ModelMap()).toString()).isEqualTo(new ModelAndView("login", "uzytkownik", new UzytkownikDTO()).toString());
    }
}