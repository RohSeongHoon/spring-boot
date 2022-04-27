package com.devagit.springbootstudy.infra;

import com.devagit.springbootstudy.response.MovieCompanyResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MovieCompanyClientTest {
    @Autowired
    private MovieCompanyClient movieCompanyClient;

    @Test
    public void getMovieCompanyListTest(){
        MovieCompanyResponse.CompanyListResult result = movieCompanyClient.getMovieCompanyList(null,null);
        System.out.println(result.getTotCnt());
    }

}