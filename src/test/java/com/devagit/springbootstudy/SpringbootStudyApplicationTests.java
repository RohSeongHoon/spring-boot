package com.devagit.springbootstudy;

import com.devagit.springbootstudy.infra.NaverMapCategoriesResponse;
import com.devagit.springbootstudy.infra.NaverMapClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootStudyApplicationTests {

    @Autowired
    NaverMapClient naverMapClient;

    @Test
    void contextLoads() {
        List<NaverMapCategoriesResponse> result = naverMapClient.getNaverMap();
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).getId());
        }
    }

}
