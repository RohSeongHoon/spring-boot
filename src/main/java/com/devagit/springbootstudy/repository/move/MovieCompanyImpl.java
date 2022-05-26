package com.devagit.springbootstudy.repository.move;

import com.devagit.springbootstudy.domain.MovieCompany;
import org.springframework.stereotype.Repository;

@Repository
public class MovieCompanyImpl implements MovieCompanyRepository{

    private final MovieCompanyJpaRepository jpaRepository;

    public MovieCompanyImpl(MovieCompanyJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public void save(MovieCompany movieCompany){
        jpaRepository.save(movieCompany);
    }
}
