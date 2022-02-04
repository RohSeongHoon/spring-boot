package com.devagit.springbootstudy.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FindIdByUserPhoneNumRequest {
    private String phoneNumber;
    private String username;
}
