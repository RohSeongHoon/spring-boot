package com.devagit.springbootstudy.util;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
public class Paging {
    public long total;
    public String cursor;

    public Paging(String cursor,Long total) {
        setCursor(cursor);
        setTotal(total);
    }
    public void setTotal(Long total) {
        if (total == null){
            this.total = 10;
        }
    }

    public void setCursor(String cursor) {
        if (cursor==null){
            LocalDateTime now = LocalDateTime.now();
            this.cursor = now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }
    }
}
