package com.example.inzynier.java.com.example.inzynier.Assembler;

import com.example.inzynier.Assembler.ZiolaAssembler;
import com.example.inzynier.DTO.ZiolaDTO;
import com.example.inzynier.tables.Ziola;
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
public class ZiolaAssemblerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private ZiolaAssembler ziolaAssembler;

    private Ziola ziola;
    private ZiolaDTO ziolaDTO;
    private List<Ziola> list;
    private List<ZiolaDTO> listDto;

    @Before
    public void init(){
        List<String> str = new ArrayList<>();
        str.add("tlo7.jpg");
        str.add("tlo8.jpg");
        List<Integer> intg = new ArrayList<>();
        intg.add(1);
        intg.add(2);
        ziola = new Ziola("Jaskolcze ziele","tlo7.jpg-1x1;tlo8.jpg-2x2","...","jaskolcze.png");
        ziolaDTO = new ZiolaDTO("Jaskolcze ziele",str, intg, intg,"...","jaskolcze.png");
        list = new ArrayList<>();
        listDto = new ArrayList<>();
        list.add(ziola);
        listDto.add(ziolaDTO);
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void toDto() {
        final ZiolaDTO tmp = ziolaAssembler.toDto(ziola);
        Assertions.assertThat(tmp).isEqualTo(ziolaDTO);
    }

    @Test
    public void toDto1() {
        final List<ZiolaDTO> tmp = ziolaAssembler.toDto(list);
        Assertions.assertThat(tmp).isEqualTo(listDto);
    }

    @Test
    public void toEntity() {
        final ZiolaDTO tmp = ziolaAssembler.toDto(ziola);
        Assertions.assertThat(tmp).isEqualTo(ziolaDTO);
    }

    @Test
    public void toEntity1() {
        final List<Ziola> tmp = ziolaAssembler.toEntity(listDto);
        Assertions.assertThat(tmp).isEqualTo(list);
    }
}