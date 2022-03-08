package com.devagit.springbootstudy.request.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FindIdByUserEmailRequest {
    private String email;
    private String username;

    public FindIdByUserEmailRequest(String email, String username) {
        this.email = email;
        this.username = username;
    }
}
