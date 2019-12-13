package com.example.inzynier.java.com.example.inzynier.Assembler;

import com.example.inzynier.Assembler.BestieAssembler;
import com.example.inzynier.DTO.BestieDTO;
import com.example.inzynier.tables.Bestie;
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
public class BestieAssemblerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private BestieAssembler bestieAssembler;

    private Bestie bestie;
    private BestieDTO bestieDTO;
    private List<Bestie> lista;
    private List<BestieDTO> listaDTO;

    @Before
    public void init(){
        bestie = new Bestie("Wilk","wilk.png","1x1","30x20");
        bestieDTO = new BestieDTO("Wilk","wilk.png","1x1","30x20");
        lista = new ArrayList<>();
        listaDTO = new ArrayList<>();
        lista.add(bestie);
        listaDTO.add(bestieDTO);
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void toDto() {
        final BestieDTO tmp = bestieAssembler.toDto(bestie);
        Assertions.assertThat(tmp).isEqualTo(bestieDTO);
    }

    @Test
    public void toDto1() {
        final List<BestieDTO> tmp = bestieAssembler.toDto(lista);
        Assertions.assertThat(tmp).isEqualTo(listaDTO);
    }

    @Test
    public void toEntity() {
        final Bestie tmp = bestieAssembler.toEntity(bestieDTO);
        Assertions.assertThat(tmp).isEqualTo(bestie);
    }

    @Test
    public void toEntity1() {
        final List<Bestie> tmp = bestieAssembler.toEntity(listaDTO);
        Assertions.assertThat(tmp).isEqualTo(lista);
    }
}