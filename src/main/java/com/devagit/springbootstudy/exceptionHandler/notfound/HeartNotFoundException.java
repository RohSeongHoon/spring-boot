package com.devagit.springbootstudy.exceptionHandler.notfound;

public class HeartNotFoundException extends NotFoundException{
    public HeartNotFoundException() {
        super("하트를 찾지 못했습니다");
    }
}
