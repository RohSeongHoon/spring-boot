package com.devagit.springbootstudy.infra;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NaverMovieSearchClientTest {
    @Autowired
    NaverMovieSearchClient client;

    @Test
    public void getNaverMovieSearch() {
        System.out.println(client.getNaverMovieSearch("해운대"));
    }
}