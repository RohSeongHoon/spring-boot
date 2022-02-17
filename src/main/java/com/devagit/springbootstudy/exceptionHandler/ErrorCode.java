package com.devagit.springbootstudy.exceptionHandler;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class ErrorCode {


    private final HttpStatus httpStatus;
    private final String detailMessage;

    public ErrorCode(HttpStatus httpStatus, String detailMessage) {
        this.httpStatus = httpStatus;
        this.detailMessage = detailMessage;
    }
}
