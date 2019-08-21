package com.example.inzynier.Controller;

import com.example.inzynier.Assembler.UzytkownikAssembler;
import com.example.inzynier.DTO.UzytkownikRejestracjaDTO;
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


@RunWith(SpringRunner.class)
@SpringBootTest
public class RejestracjaControllerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private RejestracjaController rejestracjaController;

    @Autowired
    private UzytkownikRepositories uzytkownikRepositories;

    @Autowired
    private UzytkownikAssembler uzytkownikAssembler;

    private UzytkownikRejestracjaDTO uzytkownikDTO;

    @Before
    public void init(){
        uzytkownikDTO = new UzytkownikRejestracjaDTO(
                "Admin",
                "Admin",
                "Admin",
                "Mag",
                'K');
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void zarejestruj() {
        Assertions.assertThat(
                rejestracjaController.zarejestruj().toString())
                .isEqualTo(
                        new ModelAndView(
                                "/rejestracja",
                                "uzytkownik",
                                new UzytkownikRejestracjaDTO()).toString());
    }

    @Test
    public void register() {
        uzytkownikDTO.setLogin("Nowy");
        Assertions.assertThat(
                rejestracjaController.register(
                        uzytkownikDTO,
                        new ModelMap()
                ).toString()
        ).
                isEqualTo(
                        new ModelAndView(
                                "login",
                                "uzytkownik",
                                uzytkownikAssembler.toDto(uzytkownikRepositories.findByLogin("Nowy").get())
                        ).toString()
                );
    }

    @Test
    public void loginInUse() {
        Assertions.assertThat(
                rejestracjaController.register(
                        uzytkownikDTO,
                        new ModelMap()).toString()
        )
                .isEqualTo(
                        new ModelAndView(
                                "rejestracja",
                                "uzytkownik",
                                new UzytkownikRejestracjaDTO()
                        ).
                                toString()
                );
    }
}