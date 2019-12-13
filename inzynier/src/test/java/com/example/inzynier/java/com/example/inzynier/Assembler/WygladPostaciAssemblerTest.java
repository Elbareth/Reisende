package com.example.inzynier.java.com.example.inzynier.Assembler;

import com.example.inzynier.Assembler.WygladPostaciAssembler;
import com.example.inzynier.DTO.WygladPostaciDTO;
import com.example.inzynier.tables.WygladPostaci;
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
public class WygladPostaciAssemblerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private WygladPostaciAssembler wygladPostaciAssembler;

    private WygladPostaci wygladPostaci;
    private WygladPostaciDTO wygladPostaciDTO;
    private List<WygladPostaci> list;
    private List<WygladPostaciDTO> listDto;

    @Before
    public void init(){
        wygladPostaci = new WygladPostaci("Szatyn Wojownik","Wojownik","szatyn.png","M");
        wygladPostaciDTO = new WygladPostaciDTO("Szatyn Wojownik","Wojownik","szatyn.png","M");
        list = new ArrayList<>();
        listDto = new ArrayList<>();
        list.add(wygladPostaci);
        listDto.add(wygladPostaciDTO);
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void toDto() {
        final WygladPostaciDTO tmp = wygladPostaciAssembler.toDto(wygladPostaci);
        Assertions.assertThat(tmp).isEqualTo(wygladPostaciDTO);
    }

    @Test
    public void toDto1() {
        final List<WygladPostaciDTO> tmp = wygladPostaciAssembler.toDto(list);
        Assertions.assertThat(tmp).isEqualTo(listDto);
    }

    @Test
    public void toEntity() {
        final WygladPostaciDTO tmp = wygladPostaciAssembler.toDto(wygladPostaci);
        Assertions.assertThat(tmp).isEqualTo(wygladPostaciDTO);
    }

    @Test
    public void toEntity1() {
        final List<WygladPostaci> tmp = wygladPostaciAssembler.toEntity(listDto);
        Assertions.assertThat(tmp).isEqualTo(list);
    }
}