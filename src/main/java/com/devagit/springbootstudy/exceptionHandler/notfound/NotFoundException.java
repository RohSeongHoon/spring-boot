package com.devagit.springbootstudy.exceptionHandler.notfound;

import com.devagit.springbootstudy.exceptionHandler.BusinessException;
import com.devagit.springbootstudy.exceptionHandler.ErrorCode;
import org.springframework.http.HttpStatus;

public class NotFoundException extends BusinessException {

    public NotFoundException(String message) {
        super(new ErrorCode(HttpStatus.NOT_FOUND, message));
    }

}
