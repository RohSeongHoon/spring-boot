package com.devagit.springbootstudy.infra;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class NaverMapClientTest {
    @Autowired
    NaverMapClient naverMapClient;

    @Test
    public void getNaverMapTest() {
        System.out.println(naverMapClient.getNaverMap());
    }
}