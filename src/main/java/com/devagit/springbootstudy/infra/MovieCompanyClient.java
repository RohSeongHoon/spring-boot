package com.devagit.springbootstudy.infra;

import com.devagit.springbootstudy.response.DetailCompanyInfoResponse;
import com.devagit.springbootstudy.response.DetailCompanyInfoResponse.CompanyInfo;
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

    public MovieCompanyResponse.CompanyListResult getMovieCompanyList(@Nullable Integer curPage, @Nullable Integer itemPerPage, @Nullable String ceoNm, @Nullable String companyNm) {
        String uri = UriComponentsBuilder
                .newInstance()
                .scheme("https")
                .host("kobis.or.kr")
                .path("/kobisopenapi/webservice/rest/company/searchCompanyList.json")
                .queryParam("key", "17fbde902e135f6b018113f7e1453541")
                .queryParamIfPresent("curPage", Optional.ofNullable(curPage))
                .queryParamIfPresent("itemPerPage", Optional.ofNullable(itemPerPage))
                .queryParamIfPresent("ceoNm", Optional.ofNullable(ceoNm))
                .queryParamIfPresent("companyNm", Optional.ofNullable(companyNm))
                .build()
                .toUriString();
        ResponseEntity<MovieCompanyResponse> movieCompanyList = restTemplate.exchange(uri, HttpMethod.GET, null, MovieCompanyResponse.class);
        return movieCompanyList.getBody().getCompanyListResult();
    }

    public CompanyInfo getDetailCompanyInfo(String companyCd) {
        String uri = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host("kobis.or.kr")
                .path("/kobisopenapi/webservice/rest/company/searchCompanyInfo.json")
                .queryParam("key", "17fbde902e135f6b018113f7e1453541")
                .queryParam("companyCd", companyCd)
                .build()
                .toUriString();
        ResponseEntity<DetailCompanyInfoResponse> company = restTemplate.exchange(uri, HttpMethod.GET, null, DetailCompanyInfoResponse.class);
        return company.getBody().getCompanyInfoResult().getCompanyInfo();
    }
}
