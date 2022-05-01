package com.devagit.springbootstudy.infra;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieClientTest {
    @Autowired
    private MovieClient movieClient;

    @Test
    void getMovieList() {
        String result = movieClient.getMovieList("20211509");
        System.out.println(result);

    }
}