package com.devagit.springbootstudy.domain.user;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FindPasswordByUserIdRequest {
    private String userId;
    private String userName;
    private String phoneNumber;


}
