package com.devagit.springbootstudy.request.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UserRequest {
    private String username;
    private LocalDateTime birthday;
    private String gender;
    private String userId;
    private String password;
    private String email;
    private String profileImg;
    private String introduction;
    private String instarId;


    public UserRequest(String username,LocalDateTime birthday,String gender, String userId, String password, String email, String profileImg, String introduction, String instarId) {
        this.username = username;
        this.birthday = birthday;
        this.gender = gender;
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.profileImg = profileImg;
        this.introduction = introduction;
        this.instarId = instarId;
    }
}
