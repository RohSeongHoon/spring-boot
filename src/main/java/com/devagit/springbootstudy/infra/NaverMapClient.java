package com.devagit.springbootstudy.infra;


import com.devagit.springbootstudy.exceptionHandler.restTemplateExceptionHandler.TimeOutExceptionHandler;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Component
public class NaverMapClient {
    private final RestTemplate restTemplate;

    public NaverMapClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getNaverMap() {
        try {
            ResponseEntity<String> data = restTemplate.exchange("http://localhost:3000/categories", HttpMethod.GET, null, String.class);
            return data.getBody();
        } catch (ResourceAccessException e) {
            throw new TimeOutExceptionHandler();
        }
    }



}

