package com.devagit.springbootstudy.response;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CheckTokenResponseEntity {
    private String token;

    public CheckTokenResponseEntity(String token) {
        this.token = token;
    }

    public static CheckTokenResponseEntity from(String token){
        return new CheckTokenResponseEntity(token);
    }
}
