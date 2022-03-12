package com.devagit.springbootstudy.view.user;

import com.devagit.springbootstudy.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserView {
    private long id;
    private String userName;
    private String userId;

    public UserView(long id, String userName, String userId) {
        this.id = id;
        this.userName = userName;
        this.userId = userId;
    }

    public static UserView from(User user) {
        return new UserView(user.getId(), user.getUsername(), user.getUserId());
    }

}
