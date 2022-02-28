package com.devagit.springbootstudy.exceptionHandler.badrequest;

public class UserBadRequestException extends BadRequestException{
    public UserBadRequestException(String message) {
        super(message);
    }
}
