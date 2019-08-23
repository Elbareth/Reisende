package com.example.inzynier.BasicService;

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
public class HashPasswordTest {

    @Autowired
    protected Flyway flyway;

    @Autowired
    private HashPassword hash;

    @Before
    public void init(){
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void hashMyPassword() {
        String shashowaneHaslo = null;
        Assertions.assertThat(hash.hashMyPassword("Admin",shashowaneHaslo)).isEqualTo("87639401321364826396195642631510383779176952804949321024754455897071731039599");
    }
}