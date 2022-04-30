package com.devagit.springbootstudy.infra;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class NaverMovieSearchClient {

    private RestTemplate restTemplate;

    public NaverMovieSearchClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getNaverMovieSearch(String keyWord) {
        URI uri = UriComponentsBuilder
                .newInstance()
                .scheme("https")
                .host("openapi.naver.com")
                .path("/v1/search/movie.json")
                .queryParam("query", keyWord)
                .encode()
                .build()
                .toUri();

        RequestEntity requestEntity = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", "")
                .header("X-Naver-Client-Secret", "")
                .build();

        ResponseEntity<String> test = restTemplate.exchange(requestEntity, String.class);
        return test.getBody();
    }
}
