package com.devagit.springbootstudy.exceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException e){
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }

}
