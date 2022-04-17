package com.devagit.springbootstudy.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CompanyListResult {
    private int totCnt;
    private List<CompanyList> companyLists;

    public CompanyListResult(int totCnt, List<CompanyList> companyLists) {
        this.totCnt = totCnt;
        this.companyLists = companyLists;
    }
}
