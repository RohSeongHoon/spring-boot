package com.devagit.springbootstudy.exceptionHandler;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
public class ErrorResponse {
    private String message;
    private String error;
    private int status;

    @Builder
    private ErrorResponse(String error, String message,int status) {
        this.error = error;
        this.message = message;
        this.status = status;
    }

    public static ResponseEntity<ErrorResponse> toResponseEntity(ErrorCode errorCode) {
      return  ResponseEntity.status(errorCode.getHttpStatus())
                .body(ErrorResponse.builder()
                        .error(errorCode.getHttpStatus().name())
                        .message(errorCode.getDetailMessage())
                        .status(errorCode.getHttpStatus().value())
                        .build()
                );
    }


}
