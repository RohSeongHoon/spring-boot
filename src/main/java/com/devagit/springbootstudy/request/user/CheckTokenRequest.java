package com.devagit.springbootstudy.request.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class CheckTokenRequest {
    private String token;
    private String refreshToken;
    private LocalDateTime expDate;

    public CheckTokenRequest(String token, String refreshToken, LocalDateTime expDate) {
        this.token = token;
        this.refreshToken = refreshToken;
        this.expDate = expDate;
    }
}
