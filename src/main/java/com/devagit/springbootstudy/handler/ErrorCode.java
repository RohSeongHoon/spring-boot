package com.devagit.springbootstudy.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorCode {
    private String message;
    private HttpStatus status;
    private String errorCode;

    public ErrorCode(String message, HttpStatus status, String errorCode) {
        this.message = message;
        this.status = status;
        this.errorCode = errorCode;
    }

}
