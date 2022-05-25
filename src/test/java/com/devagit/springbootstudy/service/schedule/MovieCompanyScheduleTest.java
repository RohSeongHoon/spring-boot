package com.devagit.springbootstudy.service.schedule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieCompanyScheduleTest {
    @Autowired
    private MovieCompanySchedule movieCompanySchedule;

    @Test
    public void MovieCompanyScheduleTest(){
        movieCompanySchedule.saveMovieClient();
    }

}