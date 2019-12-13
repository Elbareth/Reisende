package com.example.inzynier.Service;

import com.example.inzynier.Assembler.MebleAssembler;
import com.example.inzynier.DTO.MebleDTO;
import com.example.inzynier.Repositories.MebleRepositories;
import org.assertj.core.api.Assertions;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MebleServiceTest {

    @Autowired
    private MebleService mebleService;
    @Autowired
    private MebleRepositories mebleRepositories;
    @Autowired
    private MebleAssembler mebleAssembler;
    @Autowired
    private Flyway flyway;
    private MebleDTO mebleDTO;

    @Before
    public void init(){
        mebleDTO = new MebleDTO(
                "ArtDecoStol",
                "artDecoStol.png",
                "Stoly",
                300f,
                0,
                0,
                0,
                0,
                300
        );
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void getByNazwa() {
        Assertions.assertThat(mebleService.getByNazwa("ArtDecoStol")).isEqualTo(mebleDTO);
    }

    @Test
    public void getByKategoria() {
        List<MebleDTO> array;
        array = mebleAssembler.toDto(mebleRepositories.findByKategoria("Stoly"));
        Assertions.assertThat(mebleService.getByKategoria("Stoly")).isEqualTo(array);
    }

    @Test
    public void getListAll() {
        Assertions.assertThat(mebleService.getListAll()).isEqualTo(mebleAssembler.toDto(mebleRepositories.findAll()));
    }

    @Test
    public void getListKuchnii() {
        List<MebleDTO> array = new ArrayList<>();
        array.addAll(mebleService.getByKategoria("Szafki"));
        array.addAll(mebleService.getByKategoria("Zlew"));
        array.addAll(mebleService.getByKategoria("Kuchnia"));
        array.addAll(mebleService.getByKategoria("Lodowki"));
        array.addAll(mebleService.getByKategoria("Krzesla"));
        array.addAll(mebleService.getByKategoria("Stoly"));
        Assertions.assertThat(mebleService.getListKuchnii()).isEqualTo(array);
    }

    @Test
    public void getListKuchniiPliki() {
        List<String> array = new ArrayList<>();
        mebleService.getListKuchnii().forEach( it
                -> array.add(it.getPlik())
        );
        Assertions.assertThat(mebleService.getListKuchniiPliki()).isEqualTo(array);
    }

    @Test
    public void getListLazienki() {
        List<MebleDTO> array = new ArrayList<>();
        array.addAll(mebleService.getByKategoria("Umywalki"));
        array.addAll(mebleService.getByKategoria("Toalety"));
        array.addAll(mebleService.getByKategoria("Wanna"));
        Assertions.assertThat(mebleService.getListLazienki()).isEqualTo(array);
    }

    @Test
    public void getListLazienkiPlik() {
        List<String> array = new ArrayList<>();
        mebleService.getListLazienki().forEach( it
                -> array.add(it.getPlik())
        );
        Assertions.assertThat(mebleService.getListLazienkiPlik()).isEqualTo(array);
    }

    @Test
    public void getListSypialnii() {
        List<MebleDTO> array = new ArrayList<>();
        array.addAll(mebleService.getByKategoria("Lozka"));
        array.addAll(mebleService.getByKategoria("Szafa"));
        array.addAll(mebleService.getByKategoria("Kominki"));
        array.addAll(mebleService.getByKategoria("Fotele"));
        array.addAll(mebleService.getByKategoria("Sofa"));
        array.addAll(mebleService.getByKategoria("Barki"));
        Assertions.assertThat(mebleService.getListSypialnii()).isEqualTo(array);
    }

    @Test
    public void getListSypialniiPlik() {
        List<String> array = new ArrayList<>();
        mebleService.getListSypialnii().forEach( it
                -> array.add(it.getPlik())
        );
        Assertions.assertThat(mebleService.getListSypialniiPlik()).isEqualTo(array);
    }

    @Test
    public void getListDodatki() {
        List<MebleDTO> array = new ArrayList<>();
        array.addAll(mebleService.getByKategoria("Okna"));
        array.addAll(mebleService.getByKategoria("Drzwi"));
        array.addAll(mebleService.getByKategoria("Podloga"));
        array.addAll(mebleService.getByKategoria("Obrazy"));
        array.addAll(mebleService.getByKategoria("Dywany"));
        array.addAll(mebleService.getByKategoria("Kwiaty"));
        array.addAll(mebleService.getByKategoria("Wazony"));
        array.addAll(mebleService.getByKategoria("Trofea"));
        array.addAll(mebleService.getByKategoria("Kojec"));
        Assertions.assertThat(mebleService.getListDodatki()).isEqualTo(array);
    }

    @Test
    public void getListDodatkiPlik() {
        List<String> array = new ArrayList<>();
        mebleService.getListDodatki().forEach( it
                -> array.add(it.getPlik())
        );
        Assertions.assertThat(mebleService.getListDodatkiPlik()).isEqualTo(array);
    }

    @Test
    public void findByPlik() {
        Assertions.assertThat(mebleService.findByPlik("artDecoStol.png")).isEqualTo(mebleDTO);
    }
}