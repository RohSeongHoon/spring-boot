package com.devagit.springbootstudy.exceptionHandler.notfound;

public class CommentNotFoundException extends NotFoundException{
    public CommentNotFoundException(String message) {
        super(message);
    }
}
