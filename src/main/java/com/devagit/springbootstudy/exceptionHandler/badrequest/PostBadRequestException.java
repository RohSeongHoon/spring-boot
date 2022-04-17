package com.devagit.springbootstudy.exceptionHandler.badrequest;

public class PostBadRequestException extends BadRequestException {
    public PostBadRequestException(String message) {
        super(message);
    }
}
