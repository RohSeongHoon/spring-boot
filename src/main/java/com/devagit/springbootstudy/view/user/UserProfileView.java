package com.devagit.springbootstudy.view.user;

import com.devagit.springbootstudy.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class UserProfileView {
    private String userId;
    private String username;
    private LocalDate birthday;
    private String profileImg;
    private LocalDateTime updatedAt;


    public UserProfileView(String userId, String username, LocalDate birthday, String profileImg,LocalDateTime updatedAt) {
        this.userId = userId;
        this.username = username;
        this.birthday = birthday;
        this.profileImg = profileImg;
        this.updatedAt = updatedAt;
    }

    public static UserProfileView from(User user) {
        return new UserProfileView(user.getUserId(), user.getUsername(), user.getBirthday(), user.getProfileImg(),user.getUpdatedAt());
    }
}
