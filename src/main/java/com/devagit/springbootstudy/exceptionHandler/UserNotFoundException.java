package com.devagit.springbootstudy.exceptionHandler;


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
