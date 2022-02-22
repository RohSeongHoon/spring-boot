package com.devagit.springbootstudy.request.user;

import lombok.Builder;
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
    private String profileImg;
    private String introduction;
    private String instarId;


    public UserRequest(String username, String userId, String password, String phoneNumber, String email, String profileImg, String introduction, String instarId) {
        this.username = username;
        this.userId = userId;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.profileImg = profileImg;
        this.introduction = introduction;
        this.instarId = instarId;
    }
}
