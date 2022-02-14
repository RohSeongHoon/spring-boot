package com.devagit.springbootstudy.exceptionHandler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
public enum ErrorCode {

    USER_ID_NOT_THE_SAME(BAD_REQUEST, "ID가 올바르지 않습니다"),
    USER_PASSWORD_NOT_THE_SAME(BAD_REQUEST, "PASSWORD가 올바르지 않습니다"),
    USER_INFO_NOT_THE_SAME(BAD_REQUEST, "유저의 정보가 일치 하지 않습니다"),
    POST_NOT_FOUND(BAD_REQUEST,"게시물이 존재하지 않습니다");

    private final HttpStatus httpStatus;
    private final String detailMessage;

    ErrorCode(HttpStatus httpStatus, String detailMessage) {
        this.httpStatus = httpStatus;
        this.detailMessage = detailMessage;
    }
}
