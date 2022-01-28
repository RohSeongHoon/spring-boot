package com.devagit.springbootstudy.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserIdNotFoundException extends RuntimeException {
    private int status;
    private String message;

    public UserIdNotFoundException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.status = errorCode.getStatus();

    }
}
