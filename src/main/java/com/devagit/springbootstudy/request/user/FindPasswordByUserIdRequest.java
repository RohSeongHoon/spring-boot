package com.devagit.springbootstudy.request.user;


import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
public class FindPasswordByUserIdRequest {
    private String userId;
    private String username;
    private String phoneNumber;


    public FindPasswordByUserIdRequest(String userId, String username, String phoneNumber) {
        this.userId = userId;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }
}
