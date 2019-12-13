package com.example.inzynier.java.com.example.inzynier.Service;

import com.example.inzynier.Assembler.UzytkownikAssembler;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.Repositories.UzytkownikRepositories;
import com.example.inzynier.Service.UzytkownikService;
import org.assertj.core.api.Assertions;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UzytkownikServiceTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private UzytkownikService uzytkownikService;

    @Autowired
    private UzytkownikRepositories uzytkownikRepositories;

    @Autowired
    private UzytkownikAssembler uzytkownikAssembler;

    private UzytkownikDTO uzytkownikDTO;

    @Before
    public void init(){
        uzytkownikDTO = new UzytkownikDTO(
                "Admin",
                "87639401321364826396195642631510383779176952804949321024754455897071731039599",
                "Admin",
                "Mag",
                100,
                0,
                "Szatyn Wojownik",
                'K',
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                "brak",
                "brak",
                "brak",
                "brak",
                "brak",
                "brak",
                "brak",
                100,
                100,
                100,
                100,
                "brak",
                1,
                "1x1");
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void findByLogin() {
        Assertions.assertThat(uzytkownikService.findByLogin("Admin")).isEqualTo(uzytkownikDTO);
    }

    @Test
    public void isUserExistTrue() {
        Assertions.assertThat(uzytkownikService.isUserExist("Admin","87639401321364826396195642631510383779176952804949321024754455897071731039599")).isEqualTo(true);
    }

    @Test
    public void isUserExistFalse() {
        Assertions.assertThat(uzytkownikService.isUserExist("Admin","")).isEqualTo(false);
    }

    @Test
    public void isThisLoginInUseTrue() {
        Assertions.assertThat(uzytkownikService.isThisLoginInUse("Admin")).isEqualTo(true);
    }

    @Test
    public void isThisLoginInUseFalse() {
        Assertions.assertThat(uzytkownikService.isThisLoginInUse("AdminX")).isEqualTo(false);
    }

    @Test
    public void create() {
        UzytkownikDTO tmp = new UzytkownikDTO(
                "AdminX",
                "c1c224b03cd9bc7b6a86d77f5dace40191766c485cd55dc48caf9ac873335d6f",
                "Admin",
                "Mag",
                100,
                0,
                "Szatyn Wojownik",
                'K',
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                "brak",
                "brak",
                "brak",
                "brak",
                "brak",
                "brak",
                "brak",
                100,
                100,
                100,
                100,
                "brak",
                1,
                "1x1");
        Assertions.assertThat(uzytkownikService.create(tmp)).isEqualTo(tmp);
    }

    @Test
    public void delete() {
        int size = uzytkownikService.findAll().size();
        uzytkownikService.delete("Admin");
        Assertions.assertThat(uzytkownikService.findAll().size()).isEqualTo(size-1);
    }

    @Test
    public void deleteNotExist() {
        try{
            uzytkownikService.delete("xxx");
        }
        catch(EntityNotFoundException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("There is no user with this login");
        }
    }

    @Test
    public void update() {
        UzytkownikDTO admin = uzytkownikService.findByLogin("Admin");
        admin.setZloteMonety(1000);
        UzytkownikDTO tmp = new UzytkownikDTO(
                "Admin",
                "87639401321364826396195642631510383779176952804949321024754455897071731039599",
                "Admin",
                "Mag",
                1000,
                0,
                "Szatyn Wojownik",
                'K',
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                "brak",
                "brak",
                "brak",
                "brak",
                "brak",
                "brak",
                "brak",
                100,
                100,
                100,
                100,
                "brak",
                1,
                "1x1");
        Assertions.assertThat(uzytkownikService.update("Admin",admin)).isEqualTo(tmp);
    }

    @Test
    public void updateNotExist(){
        try{
            uzytkownikService.update("xxx",uzytkownikDTO);
        }
        catch(EntityNotFoundException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("There is no user with this login");
        }
    }

    @Test
    public void listRaking() {
        Assertions.assertThat(uzytkownikService.listRaking()).isEqualTo(uzytkownikAssembler.toDto(uzytkownikRepositories.findAllByOrderByDoswiadczenieDesc()));
    }

    @Test
    public void findAll() {
        Assertions.assertThat(uzytkownikService.findAll()).isEqualTo(uzytkownikAssembler.toDto(uzytkownikRepositories.findAll()));
    }
}