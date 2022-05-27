package com.devagit.springbootstudy.service.schedule;

import com.devagit.springbootstudy.domain.MovieCompany;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieCompanyScheduleTest {
    @Autowired
    private MovieCompanySchedule movieCompanySchedule;

    @Test
    public void MovieCompanyScheduleTest() {
        movieCompanySchedule.saveMovieClient();
    }

    @Test
    public void DynamicInsertTest() {
        MovieCompany movieCompany = new MovieCompany("key123", "회사명", "어떤곳123");
        movieCompanySchedule.testDynamicInsert(movieCompany);
    }

    @Test
    public void DynamicUpdateTest() {
        long start = System.currentTimeMillis();
        MovieCompany movieCompany = new MovieCompany("key", "다시12", "어떤곳");
        movieCompanySchedule.testDynamicUpdate(movieCompany);
        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000.0);
    }

}