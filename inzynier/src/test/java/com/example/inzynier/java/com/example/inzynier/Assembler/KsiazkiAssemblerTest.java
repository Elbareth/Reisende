package com.example.inzynier.java.com.example.inzynier.Assembler;

import com.example.inzynier.Assembler.KsiazkiAssembler;
import com.example.inzynier.DTO.KsiazkiDTO;
import com.example.inzynier.tables.Ksiazki;
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
public class KsiazkiAssemblerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private KsiazkiAssembler ksiazkiAssembler;

    private Ksiazki ksiazki;
    private KsiazkiDTO ksiazkiDTO;
    private List<Ksiazki> list;
    private List<KsiazkiDTO> listDto;

    @Before
    public void init(){
        ksiazki = new Ksiazki("Poradnik","...",10);
        ksiazkiDTO = new KsiazkiDTO("Poradnik","...",10);
        list = new ArrayList<>();
        listDto = new ArrayList<>();
        list.add(ksiazki);
        listDto.add(ksiazkiDTO);
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void toDto() {
        final KsiazkiDTO tmp = ksiazkiAssembler.toDto(ksiazki);
        Assertions.assertThat(tmp).isEqualTo(ksiazkiDTO);
    }

    @Test
    public void toDto1() {
        final List<KsiazkiDTO> tmp = ksiazkiAssembler.toDto(list);
        Assertions.assertThat(tmp).isEqualTo(listDto);
    }

    @Test
    public void toEntity() {
        final Ksiazki tmp = ksiazkiAssembler.toEntity(ksiazkiDTO);
        Assertions.assertThat(tmp).isEqualTo(ksiazki);
    }

    @Test
    public void toEntity1() {
        final List<Ksiazki> tmp = ksiazkiAssembler.toEntity(listDto);
        Assertions.assertThat(tmp).isEqualTo(list);
    }
}