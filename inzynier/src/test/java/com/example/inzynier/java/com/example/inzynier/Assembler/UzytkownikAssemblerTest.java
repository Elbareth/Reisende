package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.UzytkownikDTO;
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
public class UzytkownikAssemblerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private UzytkownikAssembler uzytkownikAssembler;

    private Uzytkownik uzytkownik;
    private UzytkownikDTO uzytkownikDTO;
    private List<Uzytkownik> list;
    private List<UzytkownikDTO> listDto;

    @Before
    public void init(){
        uzytkownik = new Uzytkownik(
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
        list = new ArrayList<>();
        listDto = new ArrayList<>();
        list.add(uzytkownik);
        listDto.add(uzytkownikDTO);
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void toDto() {
        final UzytkownikDTO tmp = uzytkownikAssembler.toDto(uzytkownik);
        Assertions.assertThat(tmp).isEqualTo(uzytkownikDTO);
    }

    @Test
    public void toDto1() {
        final List<UzytkownikDTO> tmp = uzytkownikAssembler.toDto(list);
        Assertions.assertThat(tmp).isEqualTo(listDto);
    }

    @Test
    public void toEntity() {
        final UzytkownikDTO tmp = uzytkownikAssembler.toDto(uzytkownik);
        Assertions.assertThat(tmp).isEqualTo(uzytkownikDTO);
    }

    @Test
    public void toEntity1() {
        final List<Uzytkownik> tmp = uzytkownikAssembler.toEntity(listDto);
        Assertions.assertThat(tmp).isEqualTo(list);
    }
}