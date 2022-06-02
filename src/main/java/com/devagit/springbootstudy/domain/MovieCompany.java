package com.devagit.springbootstudy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "movie_company")
public class MovieCompany {
    @Id
    private String companyCd;
    @Column(columnDefinition = "varchar(32)", nullable = false)
    private String companyName;
    @Column(columnDefinition = "varchar(64)", nullable = false)
    private String companyPartNames;

    @Builder
    public MovieCompany(String companyCd, String companyName, String companyPartNames) {
        this.companyCd = companyCd;
        this.companyName = companyName;
        this.companyPartNames = companyPartNames;
    }
}
