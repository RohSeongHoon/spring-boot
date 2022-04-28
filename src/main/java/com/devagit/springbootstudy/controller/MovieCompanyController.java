package com.devagit.springbootstudy.controller;

import com.devagit.springbootstudy.response.MovieCompanyResponse;
import com.devagit.springbootstudy.service.MovieCompanyService;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieCompanyController {

    private MovieCompanyService movieCompanyService;

    public MovieCompanyController(MovieCompanyService movieCompanyService) {
        this.movieCompanyService = movieCompanyService;
    }

    @GetMapping("/api/v1/movieCompany")
    public MovieCompanyResponse.CompanyListResult getCompanyList(@RequestParam @Nullable Integer curPage,@RequestParam @Nullable Integer itemPerPage) {
        return movieCompanyService.getMovieCompanyList(curPage, itemPerPage);
    }
}
