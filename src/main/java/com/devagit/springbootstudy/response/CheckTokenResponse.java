package com.devagit.springbootstudy.response;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CheckTokenResponse {
    private String token;

    public CheckTokenResponse(String token) {
        this.token = token;
    }

    public static CheckTokenResponse from(String token){
        return new CheckTokenResponse(token);
    }
}
