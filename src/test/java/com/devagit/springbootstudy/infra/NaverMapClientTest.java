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
        for (int i = 0; i < naverMapClient.getNaverMap().size(); i++) {
            System.out.println("category id =" + naverMapClient.getNaverMap().get(i).getId());
            System.out.println("category name =" + naverMapClient.getNaverMap().get(i).getName());
            System.out.println("category name_kr =" + naverMapClient.getNaverMap().get(i).getNameKr());

        }
    }

}