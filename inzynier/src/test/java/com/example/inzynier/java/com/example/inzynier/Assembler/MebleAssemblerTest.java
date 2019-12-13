package com.example.inzynier.java.com.example.inzynier.Assembler;

import com.example.inzynier.Assembler.MebleAssembler;
import com.example.inzynier.DTO.MebleDTO;
import com.example.inzynier.tables.Meble;
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
public class MebleAssemblerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private MebleAssembler mebleAssembler;

    private Meble meble;
    private MebleDTO mebleDTO;
    private List<Meble> list;
    private List<MebleDTO> listDto;

    @Before
    public void init(){
        meble = new Meble("Stol","stol.png","Stoly",100.0f,10,0,0,0,25);
        mebleDTO = new MebleDTO("Stol","stol.png","Stoly",100.0f,10,0,0,0,25);
        list = new ArrayList<>();
        listDto = new ArrayList<>();
        list.add(meble);
        listDto.add((mebleDTO));
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void toDto() {
        final MebleDTO tmp = mebleAssembler.toDto(meble);
        Assertions.assertThat(tmp).isEqualTo(mebleDTO);
    }

    @Test
    public void toDto1() {
        final List<MebleDTO> tmp = mebleAssembler.toDto(list);
        Assertions.assertThat(tmp).isEqualTo(listDto);
    }

    @Test
    public void toEntity() {
        final Meble tmp = mebleAssembler.toEntity(mebleDTO);
        Assertions.assertThat(tmp).isEqualTo(meble);
    }

    @Test
    public void toEntity1() {
        final List<Meble> tmp = mebleAssembler.toEntity(listDto);
        Assertions.assertThat(tmp).isEqualTo(list);
    }
}