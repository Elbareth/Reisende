package com.example.inzynier.Service;

import com.example.inzynier.Assembler.UzytkownikAssembler;
import com.example.inzynier.Assembler.WiadomosciAssembler;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.DTO.WiadomosciDTO;
import com.example.inzynier.Repositories.WiadomosciRepositories;
import org.assertj.core.api.Assertions;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WiadomosciServiceTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private WiadomosciService wiadomosciService;

    @Autowired
    private WiadomosciRepositories wiadomosciRepositories;

    @Autowired
    private UzytkownikAssembler uzytkownikAssembler;

    @Autowired
    private WiadomosciAssembler wiadomosciAssembler;

    private UzytkownikDTO uzytkownikDTO;
    private WiadomosciDTO wiadomosciDTO;

    @Before
    public void init(){
        uzytkownikDTO = new UzytkownikDTO(
                "Admin",
                "c1c224b03cd9bc7b6a86d77f5dace40191766c485cd55dc48caf9ac873335d6f",
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
        wiadomosciDTO = new WiadomosciDTO(1,"Admin","Admin7","Wiadomosc", "Wiadomosc Wiadomosc Wiadomosc", LocalDate.of(2012,12,21));
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void findByNadawca() {
        Assertions.assertThat(wiadomosciService.findByNadawca(uzytkownikDTO)).isEqualTo(wiadomosciAssembler.toDto(wiadomosciRepositories.findAllByNadawcaOrderByDataDesc(uzytkownikAssembler.toEntity(uzytkownikDTO))));
    }

    @Test
    public void findByOdbiorca() {
        Assertions.assertThat(wiadomosciService.findByOdbiorca(uzytkownikDTO)).isEqualTo(wiadomosciAssembler.toDto(wiadomosciRepositories.findAllByOdbiorcaOrderByDataDesc(uzytkownikAssembler.toEntity(uzytkownikDTO))));
    }

    @Test
    public void findById() {
        Assertions.assertThat(wiadomosciService.findById(1)).isEqualTo(wiadomosciDTO);
    }

    @Test
    public void createWiadomosc() {
        WiadomosciDTO tmp = new WiadomosciDTO("Admin","Admin","WiadomoscX", "Wiadomosc Wiadomosc Wiadomosc", LocalDate.of(2012,12,22));
        Assertions.assertThat(wiadomosciService.createWiadomosc(tmp)).isEqualTo(tmp);
    }

    @Test
    public void deleteWiadomosc() {
        int size = wiadomosciRepositories.findAll().size();
        wiadomosciService.deleteWiadomosc(1);
        Assertions.assertThat(wiadomosciRepositories.findAll().size()).isEqualTo(size-1);
    }
}