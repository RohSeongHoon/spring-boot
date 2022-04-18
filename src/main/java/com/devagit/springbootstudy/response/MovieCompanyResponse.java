package com.devagit.springbootstudy.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
public class MovieCompanyResponse {
    private CompanyListResult companyListResult;

    public MovieCompanyResponse(CompanyListResult companyListResult) {
        this.companyListResult = companyListResult;
    }

    @NoArgsConstructor
    @Getter
    @Setter
    public static class CompanyListResult {
        private int totCnt;
        private List<CompanyList> companyLists;

        public CompanyListResult(int totCnt, List<CompanyList> companyLists) {
            this.totCnt = totCnt;
            this.companyLists = companyLists;
        }
    }

}
