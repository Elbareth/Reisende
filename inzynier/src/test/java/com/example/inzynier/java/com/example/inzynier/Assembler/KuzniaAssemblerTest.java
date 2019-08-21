package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.KuzniaDTO;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.DTO.ZbrojaDTO;
import com.example.inzynier.tables.Kuznia;
import com.example.inzynier.tables.Uzytkownik;
import com.example.inzynier.tables.Zbroja;
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
public class KuzniaAssemblerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private KuzniaAssembler kuzniaAssembler;

    private Kuznia kuznia;
    private KuzniaDTO kuzniaDTO;
    private List<Kuznia> list;
    private List<KuzniaDTO> listDto;

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
        Zbroja zbroja = new Zbroja("Mlot Thora", 20,10,10,50,"mlot.png","wszystkieKlasy","bron");
        kuznia = new Kuznia(uzytkownik, 20.0f, false, 2, zbroja,"mlot.png","wszystkieKlasy","...");
        UzytkownikDTO uzytkownikDto = new UzytkownikDTO(
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
        ZbrojaDTO zbrojaDTO = new ZbrojaDTO("Mlot Thora", 20,10,10,50,"mlot.png","wszystkieKlasy","bron");
        kuzniaDTO = new KuzniaDTO(uzytkownikDto, 20.0f, false, 2, zbrojaDTO,"mlot.png","wszystkieKlasy","...");
        list = new ArrayList<>();
        listDto = new ArrayList<>();
        list.add(kuznia);
        listDto.add(kuzniaDTO);
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void toDto() {
        final KuzniaDTO tmp = kuzniaAssembler.toDto(kuznia);
        Assertions.assertThat(tmp).isEqualTo(kuzniaDTO);
    }

    @Test
    public void toDto1() {
        final List<KuzniaDTO> tmp = kuzniaAssembler.toDto(list);
        Assertions.assertThat(tmp).isEqualTo(listDto);
    }

    @Test
    public void toEntity() {
        final Kuznia tmp = kuzniaAssembler.toEntity(kuzniaDTO);
        Assertions.assertThat(tmp).isEqualTo(kuznia);
    }

    @Test
    public void toEntity1() {
        final List<Kuznia> tmp = kuzniaAssembler.toEntity(listDto);
        Assertions.assertThat(tmp).isEqualTo(list);
    }
}