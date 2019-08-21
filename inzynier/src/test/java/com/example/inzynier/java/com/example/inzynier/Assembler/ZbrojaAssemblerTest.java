package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.ZbrojaDTO;
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
public class ZbrojaAssemblerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private ZbrojaAssembler zbrojaAssembler;

    private Zbroja zbroja;
    private ZbrojaDTO zbrojaDTO;
    private List<Zbroja> list;
    private List<ZbrojaDTO> listDto;

    @Before
    public void init(){
        zbroja = new Zbroja("Helm",0,20,1,30,"helm.png","wszystkieKlasy","Helmy");
        zbrojaDTO = new ZbrojaDTO("Helm",0,20,1,30,"helm.png","wszystkieKlasy","Helmy");
        list = new ArrayList<>();
        listDto = new ArrayList<>();
        list.add(zbroja);
        listDto.add(zbrojaDTO);
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void toDto() {
        final ZbrojaDTO tmp = zbrojaAssembler.toDto(zbroja);
        Assertions.assertThat(tmp).isEqualTo(zbrojaDTO);
    }

    @Test
    public void toDto1() {
        final List<ZbrojaDTO> tmp = zbrojaAssembler.toDto(list);
        Assertions.assertThat(tmp).isEqualTo(listDto);
    }

    @Test
    public void toEntity() {
        final ZbrojaDTO tmp = zbrojaAssembler.toDto(zbroja);
        Assertions.assertThat(tmp).isEqualTo(zbrojaDTO);
    }

    @Test
    public void toEntity1() {
        final List<Zbroja> tmp = zbrojaAssembler.toEntity(listDto);
        Assertions.assertThat(tmp).isEqualTo(list);
    }
}