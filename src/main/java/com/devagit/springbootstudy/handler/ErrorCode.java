package com.devagit.springbootstudy.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorCode {
    private String message;
    private int status;
    private String errorCode;

    public ErrorCode(String message, int status, String errorCode) {
        this.message = message;
        this.status = status;
        this.errorCode = errorCode;
    }

}
