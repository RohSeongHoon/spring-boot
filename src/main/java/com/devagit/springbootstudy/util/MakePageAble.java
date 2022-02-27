package com.devagit.springbootstudy.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;

public class MakePageAble {
    public static final int DEFAULT_SIZE = 5;
    public static Timestamp currentTime = new Timestamp(System.currentTimeMillis());


    public static Pageable makePageAble( int page, Integer size) {
        if (size == null) {
            size = DEFAULT_SIZE;
        }
        return PageRequest.of(page, size);
    }
}
