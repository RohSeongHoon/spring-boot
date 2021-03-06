package com.devagit.springbootstudy.response;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LoginResponseEntity {
    private String token;
    private String refreshToken;

    public LoginResponseEntity(String token, String refreshToken) {
        this.token = token;
        this.refreshToken = refreshToken;
    }

    public static LoginResponseEntity from(String token, String refreshToken) {
        return new LoginResponseEntity(token, refreshToken);
    }
}
