package com.example.inzynier.java.com.example.inzynier.Assembler;

import com.example.inzynier.Assembler.InnePrzedmiotyAssembler;
import com.example.inzynier.DTO.InnePrzedmiotyDTO;
import com.example.inzynier.tables.InnePrzedmioty;
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
public class InnePrzedmiotyAssemblerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private InnePrzedmiotyAssembler innePrzedmiotyAssembler;

    private InnePrzedmioty innePrzedmioty;
    private InnePrzedmiotyDTO innePrzedmiotyDTO;
    private List<InnePrzedmioty> list;
    private List<InnePrzedmiotyDTO> listDto;

    @Before
    public void init(){
        innePrzedmioty = new InnePrzedmioty("Luneta",20.0f, "luneta.png", "...");
        innePrzedmiotyDTO = new InnePrzedmiotyDTO("Luneta",20.0f, "luneta.png", "...");
        list = new ArrayList<>();
        list.add(innePrzedmioty);
        listDto = new ArrayList<>();
        listDto.add(innePrzedmiotyDTO);
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void toDto() {
        final InnePrzedmiotyDTO tmp = innePrzedmiotyAssembler.toDto(innePrzedmioty);
        Assertions.assertThat(tmp).isEqualTo(innePrzedmiotyDTO);
    }

    @Test
    public void toDto1() {
        final List<InnePrzedmiotyDTO> tmp = innePrzedmiotyAssembler.toDto(list);
        Assertions.assertThat(tmp).isEqualTo(listDto);
    }

    @Test
    public void toEntity() {
        final InnePrzedmioty tmp = innePrzedmiotyAssembler.toEntity(innePrzedmiotyDTO);
        Assertions.assertThat(tmp).isEqualTo(innePrzedmioty);
    }

    @Test
    public void toEntity1() {
        final List<InnePrzedmioty> tmp = innePrzedmiotyAssembler.toEntity(listDto);
        Assertions.assertThat(tmp).isEqualTo(list);
    }
}