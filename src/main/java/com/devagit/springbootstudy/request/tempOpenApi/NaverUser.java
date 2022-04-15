package com.devagit.springbootstudy.request.tempOpenApi;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class NaverUser {
    private String id;
    private String password;
    private String name;
    private String nickName;
    private String email;
    private String gender;

    public NaverUser(String id, String password, String name, String nickName, String email, String gender) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.email = email;
        this.gender = gender;
    }

}
