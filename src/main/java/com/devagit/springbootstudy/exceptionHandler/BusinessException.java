package com.devagit.springbootstudy.exceptionHandler;


import lombok.Getter;

//businessException은 하나로 모든걸 관리한다

@Getter
public class BusinessException extends RuntimeException {
    private final ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return errorCode.getDetailMessage();
    }

}
