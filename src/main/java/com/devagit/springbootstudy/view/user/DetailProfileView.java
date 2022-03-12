package com.devagit.springbootstudy.view.user;

import com.devagit.springbootstudy.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class DetailProfileView {
    private String userId;
    private String username;
    private LocalDate birthday;
    private String gender;
    private String email;
    private String profileImg;
    private String introduction;
    private String instarId;
    private LocalDateTime updatedAt;

    public DetailProfileView(String userId, String username, LocalDate birthday, String gender, String email, String profileImg, String introduction, String instarId, LocalDateTime updatedAt) {
        this.userId = userId;
        this.username = username;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.profileImg = profileImg;
        this.introduction = introduction;
        this.instarId = instarId;
        this.updatedAt = updatedAt;
    }

    public static DetailProfileView from(User user) {
        return new DetailProfileView(user.getUserId(), user.getUsername(), user.getBirthday(), user.getGender(), user.getEmail(), user.getProfileImg(), user.getIntroduction(), user.getInstarId(),user.getUpdatedAt());
    }
}
