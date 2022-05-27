package com.devagit.springbootstudy.service.schedule;

import com.devagit.springbootstudy.domain.MovieCompany;
import com.devagit.springbootstudy.infra.MovieCompanyClient;
import com.devagit.springbootstudy.repository.move.MovieCompanyImpl;
import com.devagit.springbootstudy.repository.move.MovieCompanyJpaRepository;
import com.devagit.springbootstudy.repository.move.MovieCompanyRepository;
import com.devagit.springbootstudy.response.MovieCompanyResponse.Company;
import com.devagit.springbootstudy.response.MovieCompanyResponse.CompanyListResult;
import org.springframework.stereotype.Component;

@Component
public class MovieCompanySchedule {
    private MovieCompanyClient movieCompanyClient;
    private MovieCompanyRepository repository;

    public MovieCompanySchedule(MovieCompanyClient movieCompanyClient, MovieCompanyRepository repository) {
        this.movieCompanyClient = movieCompanyClient;
        this.repository = repository;
    }

    public void saveMovieClient() {
        CompanyListResult companyListResult = movieCompanyClient.getMovieCompanyList(null, null, null, null);
        for (int i = 0; i < 3; i++) {
            Company company = companyListResult.getCompanyLists().get(i);
            MovieCompany movieCompany = MovieCompany
                    .builder()
                    .companyCd(company.getCompanyCd())
                    .companyName(company.getCompanyNm())
                    .companyPartNames(company.getCompanyPartNames())
                    .build();
            repository.save(movieCompany);
        }
    }

    public void testDynamicInsert(MovieCompany movieCompany){
        repository.save(movieCompany);
    }
    public void testDynamicUpdate(MovieCompany movieCompany){
       MovieCompany company = repository.findByCompanyCd(movieCompany.getCompanyCd());
       company.setCompanyName(movieCompany.getCompanyName());
       repository.save(company);

    }
}
