package com.devagit.springbootstudy.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DetailCompanyInfoResponse {
    private CompanyInfoResult companyInfoResult;

    public DetailCompanyInfoResponse(CompanyInfoResult companyInfoResult) {
        this.companyInfoResult = companyInfoResult;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class CompanyInfoResult {
        private CompanyInfo companyInfo;

        public CompanyInfoResult(CompanyInfo companyInfo) {
            this.companyInfo = companyInfo;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class CompanyInfo {
        private String companyNm;
        private String ceoNm;
        private List<Part> parts;
        private List<Filmo> filmos;

        public CompanyInfo(String companyNm, String ceoNm, List<Part> parts, List<Filmo> filmos) {
            this.companyNm = companyNm;
            this.ceoNm = ceoNm;
            this.parts = parts;
            this.filmos = filmos;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Part {
        private String companyPartNm;

        public Part(String companyPartNm) {
            this.companyPartNm = companyPartNm;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Filmo {
        private String movieNm;
        private String companyPartNm;

        public Filmo(String movieNm, String companyPartNm) {
            this.movieNm = movieNm;
            this.companyPartNm = companyPartNm;
        }
    }
}
