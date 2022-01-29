package com.devagit.springbootstudy.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
public enum ErrorCode {

    USER_ID_NOT_THE_SAME(BAD_REQUEST, "ID가 올바르지 않습니다"),
    USER_PASSWORD_NOT_THE_SAME(BAD_REQUEST, "PASSWORD가 올바르지 않습니다");

    private final HttpStatus httpStatus;
    private final String detailMessage;

    ErrorCode(HttpStatus httpStatus, String detailMessage) {
        this.httpStatus = httpStatus;
        this.detailMessage = detailMessage;
    }
}
