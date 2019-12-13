package com.example.inzynier.Service;

import com.example.inzynier.Assembler.WygladPostaciAssembler;
import com.example.inzynier.DTO.WygladPostaciDTO;
import com.example.inzynier.Repositories.WygladPostaciRepositories;
import org.assertj.core.api.Assertions;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WygladPostaciServiceTest {

    @Autowired
    private WygladPostaciService wygladPostaciService;
    @Autowired
    private WygladPostaciRepositories wygladPostaciRepositories;
    @Autowired
    private WygladPostaciAssembler wygladPostaciAssembler;
    @Autowired
    private Flyway flyway;
    private WygladPostaciDTO wygladPostaciDTO;

    @Before
    public void init(){
        wygladPostaciDTO = new WygladPostaciDTO(
                "Blond Wojowniczka",
                "wojownik",
                "blondWojowniczka.png",
                "K"
        );
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void findById() {
        Assertions.assertThat(wygladPostaciService.findById(1)).isEqualTo(wygladPostaciDTO);
    }

    @Test
    public void findByNazwa() {
        Assertions.assertThat(wygladPostaciService.findByNazwa("Blond Wojowniczka")).isEqualTo(wygladPostaciDTO);
    }

    @Test
    public void findByPlik() {
        Assertions.assertThat(wygladPostaciService.findByPlik("blondWojowniczka.png")).isEqualTo(wygladPostaciDTO);
    }

    @Test
    public void findAll() {
        Assertions.assertThat(wygladPostaciService.findAll()).isEqualTo(wygladPostaciAssembler.toDtoWithId(wygladPostaciRepositories.findAll()));
    }
}