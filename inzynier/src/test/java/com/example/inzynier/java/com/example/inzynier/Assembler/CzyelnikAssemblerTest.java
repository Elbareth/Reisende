package com.example.inzynier.java.com.example.inzynier.Assembler;

import com.example.inzynier.Assembler.CzyelnikAssembler;
import com.example.inzynier.DTO.CzytelnikDTO;
import com.example.inzynier.DTO.KsiazkiDTO;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.tables.Czytelnik;
import com.example.inzynier.tables.Ksiazki;
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
public class CzyelnikAssemblerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private CzyelnikAssembler czytelnikAssembler;

    private Czytelnik czytelnik;
    private CzytelnikDTO czytelnikDTO;
    private List<Czytelnik> list;
    private List<CzytelnikDTO> listDto;

    @Before
    public void init(){
        Ksiazki ksiazki = new Ksiazki("Przewodnik","...",10);
        Uzytkownik uzytkownik = new Uzytkownik(
                "Admin",
                "123",
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

        czytelnik = new Czytelnik(ksiazki,uzytkownik);
        KsiazkiDTO ksiazkiDTO = new KsiazkiDTO("Przewodnik","...",10);
        UzytkownikDTO uzytkownikDTO = new UzytkownikDTO(
                "Admin",
                "123",
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
        czytelnikDTO = new CzytelnikDTO(ksiazkiDTO, uzytkownikDTO);
        list = new ArrayList<>();
        listDto = new ArrayList<>();
        list.add(czytelnik);
        listDto.add(czytelnikDTO);
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void toDto() {
        final CzytelnikDTO tmp = czytelnikAssembler.toDto(czytelnik);
        Assertions.assertThat(tmp).isEqualTo(czytelnikDTO);
    }

    @Test
    public void toDto1() {
        final List<CzytelnikDTO> tmp = czytelnikAssembler.toDto(list);
        Assertions.assertThat(tmp).isEqualTo(listDto);
    }

    @Test
    public void toEntity() {
        final Czytelnik tmp = czytelnikAssembler.toEntity(czytelnikDTO);
        Assertions.assertThat(tmp).isEqualTo(czytelnik);
    }

    @Test
    public void toEntity1() {
        final List<Czytelnik> tmp = czytelnikAssembler.toEntity(listDto);
        Assertions.assertThat(tmp).isEqualTo(list);
    }
}