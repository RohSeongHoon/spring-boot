package com.devagit.springbootstudy.exceptionHandler;

public class UserNotFoundException extends  BusinessException{

    public UserNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
