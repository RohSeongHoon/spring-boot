package com.devagit.springbootstudy.exceptionHandler.notfound;

public class PostNotFoundException extends NotFoundException {

    public PostNotFoundException() {
        super("게시글을 찾을 수 없습니다");
    }
}
