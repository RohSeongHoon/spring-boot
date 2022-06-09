package com.devagit.springbootstudy.infra;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class KakaoMapClient {
    private RestTemplate restTemplate;

    public KakaoMapClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getAddress(String keyWord) {
        URI uri = UriComponentsBuilder
                .newInstance()
                .scheme("https")
                .host("dapi.kakao.com")
                .path("/v2/local/search/keyword.json")
                .queryParam("query", keyWord)
                .encode()
                .build()
                .toUri();

        RequestEntity requestEntity = RequestEntity
                .get(uri)
                .header("Authorization","KakaoAK " + "0e057614f227f19627d37df78b497c1f")
                .build();
        ResponseEntity<String > result = restTemplate.exchange(requestEntity, String.class);
        return result.getBody();
    }
}
