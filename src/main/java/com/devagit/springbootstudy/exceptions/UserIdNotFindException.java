package com.devagit.springbootstudy.exceptions;

public class UserIdNotFindException extends RuntimeException {

    public UserIdNotFindException(String message,Throwable cause){
        super(message,cause);
    }
}
