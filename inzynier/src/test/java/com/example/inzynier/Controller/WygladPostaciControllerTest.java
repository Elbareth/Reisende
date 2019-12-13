package com.example.inzynier.Controller;

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
public class WygladPostaciControllerTest {

    @Autowired
    private WygladPostaciController wygladPostaciController;
    @Autowired
    private Flyway flyway;

    @Before
    public void init(){
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void getWygladPostaci() {
    }

    @Test
    public void getWygladPostaciCantLogin() {
    }

    @Test
    public void saveWyglad() {
    }

    @Test
    public void saveWygladCantLogin() {
    }

    @Test
    public void getZbroja() {
    }

    @Test
    public void getZbrojaCantLogin() {
    }
}