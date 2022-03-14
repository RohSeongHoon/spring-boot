package com.devagit.springbootstudy.request.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ChangeUserInfoRequest {
    private String username;
    private String gender;
    private String userId;
    private String password;
    private String email;
    private String profileImg;
    private String introduction;
    private String instarId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    public ChangeUserInfoRequest(String username, String gender, String userId, String password, String email, String profileImg, String introduction, String instarId, LocalDateTime updatedAt) {
        this.username = username;
        this.gender = gender;
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.profileImg = profileImg;
        this.introduction = introduction;
        this.instarId = instarId;
        this.updatedAt = updatedAt;
    }
}
