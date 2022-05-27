package com.devagit.springbootstudy.repository.move;

import com.devagit.springbootstudy.domain.MovieCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCompanyJpaRepository extends JpaRepository<MovieCompany,Long> {

    MovieCompany findByCompanyCd(String companyCd);
}
