package com.devagit.springbootstudy.exceptionHandler.notfound;


public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
