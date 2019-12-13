package com.example.inzynier.Service;

import com.example.inzynier.DTO.DomekDTO;
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
public class DomekServiceTest {

    @Autowired
    private DomekService domekService;
    @Autowired
    private UzytkownikService uzytkownikService;
    @Autowired
    private Flyway flyway;
    private DomekDTO domekDTO;

    @Before
    public void init(){
        domekDTO = new DomekDTO(
                "Admin",
                "20x20",
                "BialeOkno-100x5",
                "ProsteDrzwi-100x190",
                "SlomianeLozko-20x20",
                "",
                "",
                "Wiadro-150x50",
                "",
                "",
                "",
                "DziuraWZiemi-150x150",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ""
        );
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void findByWlasciciel() {
        Assertions.assertThat(domekService.findByWlasciciel("Admin")).isEqualTo(domekDTO);
    }

    @Test
    public void create() {
        Assertions.assertThat(domekService.create(domekDTO)).isEqualTo(domekDTO);
    }

    @Test
    public void update() {
        domekDTO.setZlew("zlew-12x30");
        Assertions.assertThat(domekService.update("Admin", domekDTO)).isEqualTo(domekDTO);
    }
}