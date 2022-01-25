package com.devagit.springbootstudy.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class UserIdNotFoundException extends RuntimeException {
    private static final String DETAILMESSAGE = "로그인 실패!";

    public UserIdNotFoundException() {
    super(DETAILMESSAGE);
        }
}
