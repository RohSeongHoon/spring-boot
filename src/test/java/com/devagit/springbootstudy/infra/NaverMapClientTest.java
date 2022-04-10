package com.devagit.springbootstudy.infra;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NaverMapClientTest {
    NaverMapClient naverMapClient;

    public void getNaverMapTest(){
        naverMapClient.getNaverMap();
    }
}