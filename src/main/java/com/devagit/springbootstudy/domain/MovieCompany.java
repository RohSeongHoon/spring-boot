package com.devagit.springbootstudy.domain;

import com.mysql.cj.protocol.ColumnDefinition;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String companyNm;
    @Column(columnDefinition = "varchar(8)", nullable = false)
    private String companyPartNames;
    @Column(columnDefinition = "varchar(64)")
    private String address;

    @Builder
    public MovieCompany(String companyCd, String companyNm, String companyPartNames, String address) {
        this.companyCd = companyCd;
        this.companyNm = companyNm;
        this.companyPartNames = companyPartNames;
        this.address = address;
    }
}
