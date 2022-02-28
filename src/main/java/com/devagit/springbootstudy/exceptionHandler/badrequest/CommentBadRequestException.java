package com.devagit.springbootstudy.exceptionHandler.badrequest;

public class CommentBadRequestException extends BadRequestException{
    public CommentBadRequestException(String message) {
        super(message);
    }
}
