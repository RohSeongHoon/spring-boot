package com.devagit.springbootstudy.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class MovieClient {

    @Autowired
    private RestTemplate restTemplate;

    public MovieClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getMovieList(String movieCd) {
        String uri = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host("www.kobis.or.kr")
                .path("/kobisopenapi/webservice/rest/movie/searchMovieList.json")
                .queryParam("key", "17fbde902e135f6b018113f7e1453541")
                .queryParam("movieCd", movieCd)
                .toUriString();

        ResponseEntity<String> movieList = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);
        return movieList.getBody();

    }
}
