package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.DomekDTO;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.tables.Domek;
import com.example.inzynier.tables.Uzytkownik;
import org.assertj.core.api.Assertions;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DomekAssemblerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private DomekAssembler domekAssembler;

    private Domek domek;
    private DomekDTO domekDTO;
    private List<Domek> list;
    private List<DomekDTO> listDto;

    @Before
    public void init(){
        Uzytkownik uzytkownik = new Uzytkownik(
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
        domek = new Domek(
                "Admin",
                uzytkownik,
                "pomieszczenie",
                "okno",
                "drzwi",
                "lozko",
                "wanna",
                "umywalka",
                "toaleta",
                "szafki",
                "zlew",
                "kuchenka",
                "lodowka",
                "szafa",
                "obraz",
                "dywan",
                "kominek",
                "kwiaty",
                "wazon",
                "trofea",
                "kojec",
                "krzesla",
                "fotel",
                "sofa",
                "stol",
                "barek",
                "podloga");
        UzytkownikDTO uzytkownikDTO = new UzytkownikDTO(
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
        domekDTO = new DomekDTO(
                "Admin",
                "pomieszczenie",
                "okno",
                "drzwi",
                "lozko",
                "wanna",
                "umywalka",
                "toaleta",
                "szafki",
                "zlew",
                "kuchenka",
                "lodowka",
                "szafa",
                "obraz",
                "dywan",
                "kominek",
                "kwiaty",
                "wazon",
                "trofea",
                "kojec",
                "krzesla",
                "fotel",
                "sofa",
                "stol",
                "barek",
                "podloga"
        );
        list = new ArrayList<>();
        listDto = new ArrayList<>();
        list.add(domek);
        listDto.add(domekDTO);
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void toDto() {
        final DomekDTO tmp = domekAssembler.toDto(domek);
        Assertions.assertThat(tmp).isEqualTo(domekDTO);
    }

    @Test
    public void toDto1() {
        final List<DomekDTO> tmp = domekAssembler.toDto(list);
        Assertions.assertThat(tmp).isEqualTo(listDto);
    }

    @Test
    public void toEntity() {
        final Domek tmp = domekAssembler.toEntity(domekDTO);
        Assertions.assertThat(tmp).isEqualTo(domek);
    }

    @Test
    public void toEntity1() {
        final List<Domek> tmp = domekAssembler.toEntity(listDto);
        Assertions.assertThat(tmp).isEqualTo(list);
    }
}