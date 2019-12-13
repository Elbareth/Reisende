package com.example.inzynier.java.com.example.inzynier.Assembler;

import com.example.inzynier.Assembler.BudynkiAssembler;
import com.example.inzynier.DTO.BudynkiDTO;
import com.example.inzynier.tables.Budynki;
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
public class BudynkiAssemblerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private BudynkiAssembler budynkiAssembler;

    private Budynki budynki;
    private BudynkiDTO budynkiDTO;
    private List<BudynkiDTO> listDto;
    private List<Budynki> list;

    @Before
    public void init(){
        budynki = new Budynki("Tartak","tlo1.jpg-1x1","50x20","tartak.png");
        budynkiDTO = new BudynkiDTO("Tartak","tlo1.jpg","1","1","50x20","tartak.png");
        list = new ArrayList<>();
        listDto = new ArrayList<>();
        list.add(budynki);
        listDto.add(budynkiDTO);
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void toDto() {
        final BudynkiDTO tmp = budynkiAssembler.toDto(budynki);
        Assertions.assertThat(tmp).isEqualTo(budynkiDTO);
    }

    @Test
    public void toDto1() {
        final List<BudynkiDTO> tmp = budynkiAssembler.toDto(list);
        Assertions.assertThat(tmp).isEqualTo(listDto);
    }

    @Test
    public void toEntity() {
        final Budynki tmp = budynkiAssembler.toEntity(budynkiDTO);
        Assertions.assertThat(tmp).isEqualTo(budynki);
    }

    @Test
    public void toEntity1() {
        final List<Budynki> tmp = budynkiAssembler.toEntity(listDto);
        Assertions.assertThat(tmp).isEqualTo(list);
    }
}