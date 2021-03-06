package com.devagit.springbootstudy.exceptionHandler.restTemplateExceptionHandler;

import com.devagit.springbootstudy.exceptionHandler.BusinessException;
import com.devagit.springbootstudy.exceptionHandler.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.ResponseErrorHandler;

public class ClientException extends BusinessException{

    public ClientException(HttpStatus httpStatus) {
        super(new ErrorCode(httpStatus,"잘못된 요청"));
    }
}
