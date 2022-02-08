package com.devagit.springbootstudy.exceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BusinessException.class})
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(BusinessException e) {
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }
}
