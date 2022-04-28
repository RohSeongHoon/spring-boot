package com.devagit.springbootstudy.service;

import com.devagit.springbootstudy.infra.MovieCompanyClient;
import com.devagit.springbootstudy.response.DetailCompanyInfoResponse.CompanyInfo;
import com.devagit.springbootstudy.response.MovieCompanyResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class MovieCompanyService {
    private MovieCompanyClient movieCompanyClient;

    public MovieCompanyService(MovieCompanyClient movieCompanyClient) {
        this.movieCompanyClient = movieCompanyClient;
    }

    public MovieCompanyResponse.CompanyListResult getMovieCompanyList(@Nullable Integer curPage,@Nullable Integer itemPerPage,@Nullable String ceoNm,@Nullable String companyNm) {
        return movieCompanyClient.getMovieCompanyList(curPage, itemPerPage,ceoNm,companyNm);
    }

    public CompanyInfo getDetailCompanyInfo(String companyCd) {
        return movieCompanyClient.getDetailCompanyInfo(companyCd);
    }
}
