package com.devagit.springbootstudy.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserIdNotFoundException extends RuntimeException {
    private HttpStatus status;
    private String detailMessage;

    public UserIdNotFoundException(String message, HttpStatus status, String detailMessage) {
        super(detailMessage);
        this.status = status;

    }
}
