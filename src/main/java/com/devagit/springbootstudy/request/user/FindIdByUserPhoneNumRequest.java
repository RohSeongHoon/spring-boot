package com.devagit.springbootstudy.request.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FindIdByUserPhoneNumRequest {
    private String phoneNumber;
    private String username;

    public FindIdByUserPhoneNumRequest(String phoneNumber, String username) {
        this.phoneNumber = phoneNumber;
        this.username = username;
    }
}
