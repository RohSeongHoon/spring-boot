package com.devagit.springbootstudy.request.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteUserRequest {
    private String userId;
    private String password;

    public DeleteUserRequest(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
