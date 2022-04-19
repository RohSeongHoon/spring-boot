package com.devagit.springbootstudy.infra;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KoficFilmCompanyListClientTest {
    @Autowired
    KoficFilmCompanyListClient koficFilmCompanyListClient;

    @Test
    public void getCompanyList() {
        System.out.println(koficFilmCompanyListClient.getCompanyList().getTotCnt());
        System.out.println(koficFilmCompanyListClient.getCompanyList().getCompanyLists().size());
        System.out.println(koficFilmCompanyListClient.getCompanyList());
    }
}