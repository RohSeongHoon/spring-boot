package com.devagit.springbootstudy.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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
        @JsonProperty("companyList")
        private List<CompanyList> companyLists;

        public CompanyListResult(int totCnt, List<CompanyList> companyLists) {
            this.totCnt = totCnt;
            this.companyLists = companyLists;
        }
    }

    @NoArgsConstructor
    @Getter
    @Setter
    public static class CompanyList {
        private String companyNm;
        private String companyPartNames;
        private String ceoNm;
        private String companyCd;
        private String filmoNames;

        public CompanyList(String companyNm, String companyPartNames, String ceoNm, String companyCd, String filmoNames) {
            this.companyNm = companyNm;
            this.companyPartNames = companyPartNames;
            this.ceoNm = ceoNm;
            this.companyCd = companyCd;
            this.filmoNames = filmoNames;
        }
    }


}
