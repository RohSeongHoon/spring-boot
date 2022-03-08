package com.devagit.springbootstudy.request.user;


import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
public class FindPasswordByUserIdRequest {
    private String userId;
    private String username;
    private String email;


    public FindPasswordByUserIdRequest(String userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }
}
