package com.devagit.springbootstudy.util;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class Paging {
    private long total;
    private String cursor;

    public Paging(String cursor,long total) {
        this.cursor = cursor;
        this.total = total;
    }

}
