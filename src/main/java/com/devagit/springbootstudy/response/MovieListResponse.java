package com.devagit.springbootstudy.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class MovieListResponse {
    private MovieInfoResult movieInfoResult;

    public MovieListResponse(MovieInfoResult movieInfoResult) {
        this.movieInfoResult = movieInfoResult;
    }

    @NoArgsConstructor
    @Getter
    @Setter
    public static class MovieInfoResult {
        private MovieInfo movieInfo;

        public MovieInfoResult(MovieInfo movieInfo) {
            this.movieInfo = movieInfo;
        }
    }

    @NoArgsConstructor
    @Getter
    @Setter
    public static class MovieInfo {
        private String movieCd;
        private String movieNm;
        private List<Director> directors;

        public MovieInfo(String movieCd, String movieNm, List<Director> directors) {
            this.movieCd = movieCd;
            this.movieNm = movieNm;
            this.directors = directors;
        }
    }

    @NoArgsConstructor
    @Getter
    @Setter
    public static class Director {
        private String peopleNm;

        public Director(String peopleNm) {
            this.peopleNm = peopleNm;
        }
    }
}
