package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.PostacDTO;
import com.example.inzynier.DTO.QuestyDTO;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.tables.Postac;
import com.example.inzynier.tables.Questy;
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
public class QuestyAssemblerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private QuestyAssembler questyAssembler;

    private Questy questy;
    private QuestyDTO questyDTO;
    private List<Questy> list;
    private List<QuestyDTO> listDto;

    @Before
    public void init(){
        Postac postac = new Postac("Loki","1x1","loki.png");
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
        questy = new Questy(postac, uzytkownik, "pierscien Angulara","...","Zloto",false);
        PostacDTO postacDTO = new PostacDTO("Loki","1x1","loki.png");
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
        questyDTO = new QuestyDTO(postacDTO, uzytkownikDTO, "pierscien Angulara","...","Zloto",false);
        list = new ArrayList<>();
        listDto = new ArrayList<>();
        list.add(questy);
        listDto.add(questyDTO);
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void toDto() {
        final QuestyDTO tmp = questyAssembler.toDto(questy);
        Assertions.assertThat(tmp).isEqualTo(questyDTO);
    }

    @Test
    public void toDto1() {
        final List<QuestyDTO> tmp = questyAssembler.toDto(list);
        Assertions.assertThat(tmp).isEqualTo(listDto);
    }

    @Test
    public void toEntity() {
        final Questy tmp = questyAssembler.toEntity(questyDTO);
        Assertions.assertThat(tmp).isEqualTo(questy);
    }

    @Test
    public void toEntity1() {
        final List<Questy> tmp = questyAssembler.toEntity(listDto);
        Assertions.assertThat(tmp).isEqualTo(list);
    }
}