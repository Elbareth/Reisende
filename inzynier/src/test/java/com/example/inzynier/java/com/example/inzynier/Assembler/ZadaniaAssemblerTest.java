package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.PostacDTO;
import com.example.inzynier.DTO.ZadaniaDTO;
import com.example.inzynier.tables.Postac;
import com.example.inzynier.tables.Zadania;
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
public class ZadaniaAssemblerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private ZadaniaAssembler zadaniaAssembler;

    private Zadania zadania;
    private ZadaniaDTO zadaniaDTO;
    private List<Zadania> list;
    private List<ZadaniaDTO> listDto;

    @Before
    public void init(){
        Postac postac = new Postac("Thor","1x1","thor.png");
        zadania = new Zadania("Mlot Thora","...",postac,"Zloto");
        PostacDTO postacDTO = new PostacDTO("Thor","1x1","thor.png");
        zadaniaDTO = new ZadaniaDTO("Mlot Thora","...",postacDTO,"Zloto");
        list = new ArrayList<>();
        listDto = new ArrayList<>();
        list.add(zadania);
        listDto.add(zadaniaDTO);
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void toDto() {
        final ZadaniaDTO tmp = zadaniaAssembler.toDto(zadania);
        Assertions.assertThat(tmp).isEqualTo(zadaniaDTO);
    }

    @Test
    public void toDto1() {
        final List<ZadaniaDTO> tmp = zadaniaAssembler.toDto(list);
        Assertions.assertThat(tmp).isEqualTo(listDto);
    }

    @Test
    public void toEntity() {
        final ZadaniaDTO tmp = zadaniaAssembler.toDto(zadania);
        Assertions.assertThat(tmp).isEqualTo(zadaniaDTO);
    }

    @Test
    public void toEntity1() {
        final List<Zadania> tmp = zadaniaAssembler.toEntity(listDto);
        Assertions.assertThat(tmp).isEqualTo(list);
    }
}