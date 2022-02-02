package com.devagit.springbootstudy.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FindIdByUserPhoneNumRequest {
    private String userPhoneNumber;
    private String username;
}
