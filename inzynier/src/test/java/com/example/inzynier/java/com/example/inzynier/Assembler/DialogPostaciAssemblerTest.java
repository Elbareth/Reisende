package com.example.inzynier.java.com.example.inzynier.Assembler;

import com.example.inzynier.Assembler.DialogPostaciAssembler;
import com.example.inzynier.DTO.DialogPostaciDTO;
import com.example.inzynier.DTO.PostacDTO;
import com.example.inzynier.tables.DialogPostaci;
import com.example.inzynier.tables.Postac;
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
public class DialogPostaciAssemblerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private DialogPostaciAssembler dialogPostaciAssembler;

    private DialogPostaci dialogPostaci;
    private DialogPostaciDTO dialogPostaciDTO;
    private List<DialogPostaci> list;
    private List<DialogPostaciDTO> listDto;

    @Before
    public void init(){
        Postac postac = new Postac("Thor","1x1","thor.png");
        dialogPostaci = new DialogPostaci("Mlot Thora",postac,"...");
        PostacDTO postacDTO = new PostacDTO("Thor","tlo7.png",1,1,"thor.png");
        dialogPostaciDTO = new DialogPostaciDTO("Mlot Thora","Thor","...");
        list = new ArrayList<>();
        listDto = new ArrayList<>();
        list.add(dialogPostaci);
        listDto.add(dialogPostaciDTO);
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void toDto() {
        final DialogPostaciDTO tmp = dialogPostaciAssembler.toDto(dialogPostaci);
        Assertions.assertThat(tmp).isEqualTo(dialogPostaciDTO);
    }

    @Test
    public void toDto1() {
        final List<DialogPostaciDTO> tmp = dialogPostaciAssembler.toDto(list);
        Assertions.assertThat(tmp).isEqualTo(listDto);
    }

    @Test
    public void toEntity() {
        final DialogPostaci tmp = dialogPostaciAssembler.toEntity(dialogPostaciDTO);
        Assertions.assertThat(tmp).isEqualTo(dialogPostaci);
    }

    @Test
    public void toEntity1() {
        final List<DialogPostaci> tmp = dialogPostaciAssembler.toEntity(listDto);
        Assertions.assertThat(tmp).isEqualTo(list);
    }
}