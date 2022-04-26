package com.devagit.springbootstudy.infra;


import com.devagit.springbootstudy.exceptionHandler.restTemplateExceptionHandler.TimeOutException;
import com.devagit.springbootstudy.request.tempOpenApi.NaverUser;
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

    public List<NaverMapCategoriesResponse> getNaverMap() {
        try {
            ResponseEntity<List<NaverMapCategoriesResponse>> data = restTemplate.exchange("http://localhost:3000/categories/main", HttpMethod.GET, null, new ParameterizedTypeReference<List<NaverMapCategoriesResponse>>() {
            });
            return data.getBody();
        } catch (ResourceAccessException e) {
            throw new TimeOutException();
        }
    }

    public String setNaverUser(NaverUser naverUser) {
        HttpEntity<NaverUser> request = new HttpEntity<>(naverUser);
        try {
            ResponseEntity<String> data = restTemplate.exchange("http://localhost:3000/users/signUp", HttpMethod.POST, request, String.class);
            return data.getBody();
        } catch (ResourceAccessException e) {
            throw new TimeOutException();
        }
    }
    //네이밍 수정
    //api연결
    //예외처리 강화
    //네트워크
}






