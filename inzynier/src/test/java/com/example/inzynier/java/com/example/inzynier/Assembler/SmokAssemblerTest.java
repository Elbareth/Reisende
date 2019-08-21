package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.SmokDTO;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.tables.Smok;
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
public class SmokAssemblerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private SmokAssembler smokAssembler;

    private Smok smok;
    private SmokDTO smokDTO;
    private List<Smok> list;
    private List<SmokDTO> listDto;

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
        smok = new Smok("Admin",uzytkownik, "Smok","Czerwony grozny",100,"smok.png");
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
        smokDTO = new SmokDTO("Admin", "Smok","Czerwony grozny",100,"smok.png");
        list = new ArrayList<>();
        listDto = new ArrayList<>();
        list.add(smok);
        listDto.add(smokDTO);
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void toDto() {
        final SmokDTO tmp = smokAssembler.toDto(smok);
        Assertions.assertThat(tmp).isEqualTo(smokDTO);
    }

    @Test
    public void toDto1() {
        final List<SmokDTO> tmp = smokAssembler.toDto(list);
        Assertions.assertThat(tmp).isEqualTo(listDto);
    }
}