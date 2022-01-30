package com.devagit.springbootstudy.handler;


import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;
    public UserNotFoundException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
    @Override
    public String getMessage(){
        return errorCode.getDetailMessage();
    }

}
