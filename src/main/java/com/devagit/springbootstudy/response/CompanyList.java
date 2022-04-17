package com.devagit.springbootstudy.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CompanyList {
    private String companyNm;
    private String companyPartNames;
    private String filmoNames;

    public CompanyList(String companyNm, String companyPartNames, String filmoNames) {
        this.companyNm = companyNm;
        this.companyPartNames = companyPartNames;
        this.filmoNames = filmoNames;
    }
}
