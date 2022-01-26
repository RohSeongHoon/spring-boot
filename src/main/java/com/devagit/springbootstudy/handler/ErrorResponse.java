package com.devagit.springbootstudy.handler;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {
    private LocalDateTime timestamp = LocalDateTime.now();
    private String massage;
    private HttpStatus status;
    private String errorCode;

    public ErrorResponse(String massage, HttpStatus status, String errorCode) {
        this.massage = massage;
        this.status = status;
        this.errorCode = errorCode;
    }
}
