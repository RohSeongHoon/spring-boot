package com.devagit.springbootstudy.request.user;

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
    private String email;


    public UserRequest(String username, String userId, String password, String phoneNumber,String email) {
        this.username = username;
        this.userId = userId;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
