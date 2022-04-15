package com.devagit.springbootstudy.infra;


import com.devagit.springbootstudy.exceptionHandler.restTemplateExceptionHandler.TimeOutExceptionHandler;
import com.devagit.springbootstudy.request.tempOpenApi.NaverUser;
import com.devagit.springbootstudy.response.CategoriesResponseEntity;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class NaverMapClient {
    private final RestTemplate restTemplate;

    public NaverMapClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CategoriesResponseEntity> getNaverMap() {
        try {
            ResponseEntity<List<CategoriesResponseEntity>> data = restTemplate.exchange("http://localhost:3000/categories/main", HttpMethod.GET, null, new ParameterizedTypeReference<List<CategoriesResponseEntity>>() { //
            });
            return data.getBody();
        } catch (ResourceAccessException e) {
            throw new TimeOutExceptionHandler();
        }
    }

    public String setNaverUser(NaverUser naverUser) {
        HttpEntity<NaverUser> request = new HttpEntity<>(naverUser);
        ResponseEntity<String> data = restTemplate.exchange("http://localhost:3000/users/signUp", HttpMethod.POST, request, String.class);
        return data.getBody();
    }
    //네이밍 수정
    //api연결
    //예외처리 강화
    //네트워크 
}






