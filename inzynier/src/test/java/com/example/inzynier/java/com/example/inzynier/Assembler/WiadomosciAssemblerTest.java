package com.example.inzynier.java.com.example.inzynier.Assembler;

import com.example.inzynier.Assembler.WiadomosciAssembler;
import com.example.inzynier.DTO.WiadomosciDTO;
import com.example.inzynier.tables.Uzytkownik;
import com.example.inzynier.tables.Wiadomosci;
import org.assertj.core.api.Assertions;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WiadomosciAssemblerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private WiadomosciAssembler wiadomosciAssembler;

    private Wiadomosci wiadomosci;
    private WiadomosciDTO wiadomosciDTO;
    private WiadomosciDTO wiadomosciDTO2;
    private List<Wiadomosci> list;
    private List<WiadomosciDTO> listDto;
    private List<WiadomosciDTO> listDto2;

    @Before
    public void init(){
        Uzytkownik nadawca = new Uzytkownik(
                "Admin",
                "87639401321364826396195642631510383779176952804949321024754455897071731039599",
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
        Uzytkownik odbiorca = new Uzytkownik(
                "Admin",
                "87639401321364826396195642631510383779176952804949321024754455897071731039599",
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
        wiadomosci = new Wiadomosci(nadawca, odbiorca, "tytul","...", LocalDate.of(2012,12,22), true);
        wiadomosciDTO = new WiadomosciDTO("Admin", "Admin", "tytul","...", LocalDate.of(2012,12,22), true);
        wiadomosciDTO2 = new WiadomosciDTO(1,"Admin", "Admin", "tytul","...", LocalDate.of(2012,12,22), true);
        list = new ArrayList<>();
        listDto = new ArrayList<>();
        listDto2 = new ArrayList<>();
        list.add(wiadomosci);
        listDto.add(wiadomosciDTO);
        listDto2.add(wiadomosciDTO2);
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void toDto() {
        final WiadomosciDTO tmp = wiadomosciAssembler.toDto(wiadomosci);
        Assertions.assertThat(tmp).isEqualTo(wiadomosciDTO);
    }

    @Test
    public void toDto1() {
        final List<WiadomosciDTO> tmp = wiadomosciAssembler.toDto(list);
        Assertions.assertThat(tmp).isEqualTo(listDto);
    }

    @Test
    public void toDtoWithId() {
        final WiadomosciDTO tmp = wiadomosciAssembler.toDtoWithId(wiadomosci);
        Assertions.assertThat(tmp).isEqualTo(wiadomosciDTO2);
    }

    @Test
    public void toDtoWithId1() {
        final List<WiadomosciDTO> tmp = wiadomosciAssembler.toDtoWithId(list);
        Assertions.assertThat(tmp).isEqualTo(listDto2);
    }

    @Test
    public void toEntity() {
        final WiadomosciDTO tmp = wiadomosciAssembler.toDto(wiadomosci);
        Assertions.assertThat(tmp).isEqualTo(wiadomosciDTO);
    }

    @Test
    public void toEntity1() {
        final List<Wiadomosci> tmp = wiadomosciAssembler.toEntity(listDto);
        Assertions.assertThat(tmp).isEqualTo(list);
    }
}