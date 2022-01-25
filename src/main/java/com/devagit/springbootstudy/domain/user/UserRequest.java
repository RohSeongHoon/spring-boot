package com.devagit.springbootstudy.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;

@Getter
@NoArgsConstructor
public class UserRequest {
    private String username;
    private String userId;
    private String password;
    private String phoneNumber;


    public UserRequest(String username, String userId, String password, String phoneNumber) {
        this.username = username;
        this.userId = userId;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
