package com.devagit.springbootstudy.exceptionHandler;

public class PostNotFoundException extends BusinessException {
    private ErrorCode errorCode;

    public PostNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
