package com.devagit.springbootstudy.domain.user;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChangeUserPasswordRequest {
    private String userId;
    private String password;
    private String newPassword;
}
