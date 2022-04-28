package com.devagit.springbootstudy.infra;

import com.devagit.springbootstudy.response.MovieCompanyResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Component
public class MovieCompanyClient {
    private final RestTemplate restTemplate;

    public MovieCompanyClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public MovieCompanyResponse.CompanyListResult getMovieCompanyList(Integer curPage, Integer itemPerPage) {
        String uri = UriComponentsBuilder
                .newInstance()
                .scheme("https")
                .host("kobis.or.kr")
                .path("/kobisopenapi/webservice/rest/company/searchCompanyList.json")
                .queryParam("key", "17fbde902e135f6b018113f7e1453541")
                .queryParamIfPresent("curPage", Optional.ofNullable(curPage))
                .queryParamIfPresent("itemPerPage", Optional.ofNullable(itemPerPage))
                .build()
                .toUriString();
        ResponseEntity<MovieCompanyResponse> movieCompanyList = restTemplate.exchange("https://kobis.or.kr/kobisopenapi/webservice/rest/company/searchCompanyList.json?key=17fbde902e135f6b018113f7e1453541", HttpMethod.GET, null, MovieCompanyResponse.class);
        return movieCompanyList.getBody().getCompanyListResult();
    }
}
