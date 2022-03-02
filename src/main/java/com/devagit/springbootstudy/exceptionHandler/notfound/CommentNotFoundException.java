package com.devagit.springbootstudy.exceptionHandler.notfound;

public class CommentNotFoundException extends NotFoundException{
    public CommentNotFoundException() {
        super("댓글을 찾지 못했습니다");
    }
}
