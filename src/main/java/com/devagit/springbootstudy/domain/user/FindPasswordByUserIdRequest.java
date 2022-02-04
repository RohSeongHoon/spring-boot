package com.devagit.springbootstudy.domain.user;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FindPasswordByUserIdRequest {
    private String userId;
    private String username;
    private String phoneNumber;


}
