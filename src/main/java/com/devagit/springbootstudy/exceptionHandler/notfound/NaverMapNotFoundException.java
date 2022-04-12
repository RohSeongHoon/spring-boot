package com.devagit.springbootstudy.exceptionHandler.notfound;

public class NaverMapNotFoundException extends NotFoundException{
    public NaverMapNotFoundException() {
        super("네이버 맵을 찾을 수 없습니다");
    }
}
