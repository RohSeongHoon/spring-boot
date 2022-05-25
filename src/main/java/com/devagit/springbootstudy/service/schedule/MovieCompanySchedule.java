package com.devagit.springbootstudy.service.schedule;

import com.devagit.springbootstudy.infra.MovieCompanyClient;
import com.devagit.springbootstudy.response.MovieCompanyResponse.CompanyListResult;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class MovieCompanySchedule {
    private MovieCompanyClient movieCompanyClient;

    public MovieCompanySchedule(MovieCompanyClient movieCompanyClient) {
        this.movieCompanyClient = movieCompanyClient;
    }

    public void saveMovieClient(){
        CompanyListResult companyListResult = movieCompanyClient.getMovieCompanyList();
        System.out.println(companyListResult.getTotCnt());
    }
}
