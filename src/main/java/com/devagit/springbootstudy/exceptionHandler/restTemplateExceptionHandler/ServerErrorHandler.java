package com.devagit.springbootstudy.exceptionHandler.restTemplateExceptionHandler;

import com.devagit.springbootstudy.exceptionHandler.BusinessException;
import com.devagit.springbootstudy.exceptionHandler.ErrorCode;
import org.springframework.http.HttpStatus;

public class ServerErrorHandler extends BusinessException {
    public ServerErrorHandler(HttpStatus httpStatus) {
        super(new ErrorCode(httpStatus,"서버오류"));
    }
}
