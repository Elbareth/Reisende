package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.PostacDTO;
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
public class PostacAssemblerTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private PostacAssembler postacAssembler;

    private Postac postac;
    private PostacDTO postacDTO;
    private List<Postac> list;
    private List<PostacDTO> listDto;

    @Before
    public void init(){
        postac = new Postac("Loki","1x1","loki.png");
        postacDTO = new PostacDTO("Loki","1x1","loki.png");
        list = new ArrayList<>();
        listDto = new ArrayList<>();
        list.add(postac);
        listDto.add(postacDTO);
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void toDto() {
        final PostacDTO tmp = postacAssembler.toDto(postac);
        Assertions.assertThat(tmp).isEqualTo(postacDTO);
    }

    @Test
    public void toDto1() {
        final List<PostacDTO> tmp = postacAssembler.toDto(list);
        Assertions.assertThat(tmp).isEqualTo(listDto);
    }

    @Test
    public void toEntity() {
        final Postac tmp = postacAssembler.toEntity(postacDTO);
        Assertions.assertThat(tmp).isEqualTo(postac);
    }

    @Test
    public void toEntity1() {
        final List<Postac> tmp = postacAssembler.toEntity(listDto);
        Assertions.assertThat(tmp).isEqualTo(list);
    }
}