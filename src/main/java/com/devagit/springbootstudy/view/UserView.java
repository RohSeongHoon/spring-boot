package com.devagit.springbootstudy.view;

import com.devagit.springbootstudy.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserView {
    private int id;
    private String userName;
    private String userId;

    public UserView(int id, String userName, String userId) {
        this.id = id;
        this.userName = userName;
        this.userId = userId;
    }

    public static UserView from(User user) {
        return new UserView(user.getId(), user.getUsername(), user.getUserId());
    }

}
