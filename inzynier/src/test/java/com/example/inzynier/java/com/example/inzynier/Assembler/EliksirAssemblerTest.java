package com.example.inzynier.java.com.example.inzynier.Assembler;

import com.example.inzynier.Assembler.EliksirAssembler;
import com.example.inzynier.DTO.EliksirDTO;
import com.example.inzynier.tables.Eliksir;
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
public class EliksirAssemblerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private EliksirAssembler eliksirAssembler;

    private Eliksir eliksir;
    private EliksirDTO eliksirDTO;
    private List<Eliksir> list;
    private List<EliksirDTO> listDto;

    @Before
    public void init(){
        eliksir = new Eliksir("Eliksir Mardosci",20.0f,"eliksir.png","...","...");
        eliksirDTO = new EliksirDTO("Eliksir Mardosci",20.0f,"eliksir.png","...","...");
        list = new ArrayList<>();
        listDto = new ArrayList<>();
        list.add(eliksir);
        listDto.add(eliksirDTO);
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void toDto() {
        final EliksirDTO tmp = eliksirAssembler.toDto(eliksir);
        Assertions.assertThat(tmp).isEqualTo(eliksirDTO);
    }

    @Test
    public void toDto1() {
        final List<EliksirDTO> tmp = eliksirAssembler.toDto(list);
        Assertions.assertThat(tmp).isEqualTo(listDto);
    }

    @Test
    public void toEntity() {
        final Eliksir tmp = eliksirAssembler.toEntity(eliksirDTO);
        Assertions.assertThat(tmp).isEqualTo(eliksir);
    }

    @Test
    public void toEntity1() {
        final List<Eliksir> tmp = eliksirAssembler.toEntity(listDto);
        Assertions.assertThat(tmp).isEqualTo(list);
    }
}