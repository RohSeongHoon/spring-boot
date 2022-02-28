package com.devagit.springbootstudy.exceptionHandler.notfound;

public class PostNotFoundException extends NotFoundException {

    public PostNotFoundException(String message) {
        super(message);
    }
}
