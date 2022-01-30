package com.devagit.springbootstudy.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleUserNOtFoundException(UserNotFoundException e){
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }

}
