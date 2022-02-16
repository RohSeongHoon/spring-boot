package com.devagit.springbootstudy.request.user;

//request만 따로 관리함


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

public class ChangeUserPasswordRequest {
    private String userId;
    private String password;
    private String newPassword;

    public ChangeUserPasswordRequest(String userId, String password, String newPassword) {
        this.userId = userId;
        this.password = password;
        this.newPassword = newPassword;
    }
}
