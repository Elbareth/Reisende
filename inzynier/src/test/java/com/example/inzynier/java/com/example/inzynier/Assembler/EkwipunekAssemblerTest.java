package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.EkwipunekDTO;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.tables.Ekwipunek;
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
public class EkwipunekAssemblerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private EkwipunekAssembler ekwipunekAssembler;

    private Ekwipunek ekwipunek;
    private EkwipunekDTO ekwipunekDTO;
    private List<Ekwipunek> list;
    private List<EkwipunekDTO> listDto;

    @Before
    public void init(){
        Uzytkownik uzytkownik = new Uzytkownik(
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
        ekwipunek = new Ekwipunek(uzytkownik, "Topor","topor.png","...");
        UzytkownikDTO uzytkownikDTO = new UzytkownikDTO(
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
        ekwipunekDTO = new EkwipunekDTO(uzytkownikDTO,"Topor","topor.png","...");
        list = new ArrayList<>();
        listDto = new ArrayList<>();
        list.add(ekwipunek);
        listDto.add(ekwipunekDTO);
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void toDto() {
        final EkwipunekDTO tmp = ekwipunekAssembler.toDto(ekwipunek);
        Assertions.assertThat(tmp).isEqualTo(ekwipunekDTO);
    }

    @Test
    public void toDto1() {
        final List<EkwipunekDTO> tmp = ekwipunekAssembler.toDto(list);
        Assertions.assertThat(tmp).isEqualTo(listDto);
    }

    @Test
    public void toEntity() {
        final Ekwipunek tmp = ekwipunekAssembler.toEntity(ekwipunekDTO);
        Assertions.assertThat(tmp).isEqualTo(ekwipunek);
    }

    @Test
    public void toEntity1() {
        final List<Ekwipunek> tmp = ekwipunekAssembler.toEntity(listDto);
        Assertions.assertThat(tmp).isEqualTo(list);
    }
}