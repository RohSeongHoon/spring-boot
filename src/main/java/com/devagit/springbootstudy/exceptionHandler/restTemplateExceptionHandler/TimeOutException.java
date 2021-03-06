package com.devagit.springbootstudy.exceptionHandler.restTemplateExceptionHandler;

import com.devagit.springbootstudy.exceptionHandler.BusinessException;
import com.devagit.springbootstudy.exceptionHandler.ErrorCode;
import org.springframework.http.HttpStatus;

public class TimeOutException extends BusinessException {
    public TimeOutException() {
        super(new ErrorCode(HttpStatus.REQUEST_TIMEOUT,"요청시간 초과"));

    }
}
