package com.devagit.springbootstudy.service;

import com.devagit.springbootstudy.infra.MovieCompanyClient;
import com.devagit.springbootstudy.response.MovieCompanyResponse;
import org.springframework.stereotype.Service;

@Service
public class MovieCompanyService {
    private MovieCompanyClient movieCompanyClient;

    public MovieCompanyService(MovieCompanyClient movieCompanyClient) {
        this.movieCompanyClient = movieCompanyClient;
    }

    public MovieCompanyResponse.CompanyListResult getMovieCompanyList(Integer curPage, Integer itemPerPage) {
        return movieCompanyClient.getMovieCompanyList(curPage, itemPerPage);
    }
}
