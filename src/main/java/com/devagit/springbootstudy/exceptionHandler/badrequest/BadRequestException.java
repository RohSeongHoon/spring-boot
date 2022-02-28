package com.devagit.springbootstudy.exceptionHandler.badrequest;

import com.devagit.springbootstudy.exceptionHandler.BusinessException;
import com.devagit.springbootstudy.exceptionHandler.ErrorCode;
import org.springframework.http.HttpStatus;

public class BadRequestException extends BusinessException {
    public BadRequestException(String message) {
        super(new ErrorCode(HttpStatus.BAD_REQUEST, message));
    }
}
