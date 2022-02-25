package com.devagit.springbootstudy.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public class MakePageAble {
    public static final int DEFAULT_SIZE = 5;


    public static Pageable makePageAble(Date cursor,int size,int page){
        if (size == 0) {
            size = DEFAULT_SIZE;
        }
        if (cursor  == null){
            Date now = new Date();
            cursor = now;
        }
        return  PageRequest.of(page, size);
    }
}
