package com.example.inzynier.java.com.example.inzynier.BasicService;

import com.example.inzynier.BasicService.PoborMonet;
import com.example.inzynier.DTO.UzytkownikDTO;
import org.assertj.core.api.Assertions;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PoborMonetTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private PoborMonet pobor;

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
    public void poborMonet() {
        UzytkownikDTO tmp = new UzytkownikDTO(
                "Admin",
                "Admin",
                "Admin",
                "Mag",
                98,
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
        Assertions.assertThat(pobor.poborMonet(2,uzytkownikDTO)).isEqualTo(tmp);
    }

    @Test
    public void poborMonetZero() {
        uzytkownikDTO.setZloteMonety(0);
        UzytkownikDTO tmp = new UzytkownikDTO(
                "Admin",
                "Admin",
                "Admin",
                "Mag",
                0,
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
        Assertions.assertThat(pobor.poborMonet(2,uzytkownikDTO)).isEqualTo(tmp);
    }

    @Test
    public void poborMonetJeden() {
        uzytkownikDTO.setZloteMonety(1);
        UzytkownikDTO tmp = new UzytkownikDTO(
                "Admin",
                "Admin",
                "Admin",
                "Mag",
                0,
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
        Assertions.assertThat(pobor.poborMonet(2,uzytkownikDTO)).isEqualTo(tmp);
    }
}