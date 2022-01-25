package com.devagit.springbootstudy.handler;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public class ExceptionEntity {
    private String errorCode;
    private String detailMessage;

    public ExceptionEntity(HttpStatus status, String errorCode, String detailMessage) {
        this.errorCode = errorCode;
        this.detailMessage = detailMessage;
    }
}
