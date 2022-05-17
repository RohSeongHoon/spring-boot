package com.devagit.springbootstudy.infra;

import com.devagit.springbootstudy.response.DetailCompanyInfoResponse.CompanyInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieCompanyClientTest {
    @Autowired
    private MovieCompanyClient movieCompanyClient;

    @Test
    public void detailCompanyInfo() {
        CompanyInfo result = movieCompanyClient.getDetailCompanyInfo("20122497");
        System.out.println(result.getCompanyNm());
        System.out.println(result.getFilmos().get(0).getMovieCd());
    }
}