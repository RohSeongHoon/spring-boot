package com.devagit.springbootstudy.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserIdNotFoundException.class)
    protected ResponseEntity<ErrorResponse> test() {

    }


}
