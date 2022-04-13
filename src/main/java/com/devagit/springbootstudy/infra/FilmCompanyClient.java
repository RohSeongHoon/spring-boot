package com.devagit.springbootstudy.infra;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FilmCompanyClient {
    private RestTemplate restTemplate;

    public FilmCompanyClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getFilmCompanyList() {
        ResponseEntity<String> data = restTemplate.exchange(
                "http://www.kobis.or.kr/kobisopenapi/webservice/rest/company/searchCompanyInfo?key=17fbde902e135f6b018113f7e1453541",
                HttpMethod.GET,
                null,
                String.class
        );
        return data.getBody();
    }

}
