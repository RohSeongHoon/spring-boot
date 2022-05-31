package com.devagit.springbootstudy.infra;

import com.devagit.springbootstudy.response.AddressResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KakaoMapClientTest {

    @Autowired
    private KakaoMapClient kakaoMapClient;

    @Test
    public void getAddressTest(){
       String  result = kakaoMapClient.getAddress("(주)어바웃잇");
       System.out.println(result);
    }

}