package com.devagit.springbootstudy.handler;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
public class ErrorResponse {
    private String message;
    private String error;

    @Builder
    private ErrorResponse(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public static ResponseEntity<ErrorResponse> toResponseEntity(ErrorCode errorCode) {
      return  ResponseEntity.status(errorCode.getHttpStatus())
                .body(ErrorResponse.builder()
                        .error(errorCode.getHttpStatus().name())
                        .message(errorCode.getDetailMessage()).build()
                );
    }


}
