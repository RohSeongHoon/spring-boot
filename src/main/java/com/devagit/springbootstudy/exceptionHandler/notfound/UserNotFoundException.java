package com.devagit.springbootstudy.exceptionHandler.notfound;


public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException() {
        super("회원정보를 찾을 수 없습니다");
    }
}
