package com.devagit.springbootstudy.repository.move;

import com.devagit.springbootstudy.domain.MovieCompany;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCompanyRepository {


    void save(MovieCompany movieCompany);
}
