package com.devagit.springbootstudy.infra;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FilmCompanyClientTest {
    @Autowired
    FilmCompanyClient filmCompanyClient;

    @Test
    public void getFilmCompanyList(){
        System.out.println(
        filmCompanyClient.getFilmCompanyList()
        );
    }


}