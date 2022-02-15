package com.devagit.springbootstudy.exceptionHandler;

public class PostNotFoundException extends BusinessException {
    private ErrorCode errorCode;

    public PostNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
    //404 클래스를 만들고 상속해서 사용 Not Found 예외로 하는것으로사용
    //
}
