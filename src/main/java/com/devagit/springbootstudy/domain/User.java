package com.devagit.springbootstudy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users", indexes = {
        
}
)
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String username;
    @Column(columnDefinition = "VARCHAR(20)", nullable = false, unique = true)
    private String userId;
    @Column(columnDefinition = "VARCHAR(32)", nullable = false)
    private String password;
    @Column(columnDefinition = "VARCHAR(4)")
    private String gender;
    @Column(columnDefinition = "VARCHAR(32)")
    private String phoneNumber;
    @Column(columnDefinition = "VARCHAR(128)", nullable = false)
    private String email;
    @Column(columnDefinition = "VARCHAR(562)")
    private String profileImg;
    @Column(columnDefinition = "VARCHAR(1024)")
    private String introduction;
    @Column(columnDefinition = "VARCHAR(64)")
    private String instarId;

    @Builder
    public User(String username, String userId, String password,String gender, String phoneNumber, String email, String profileImg, String introduction, String instarId) {
        this.username = username;
        this.userId = userId;
        this.password = password;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.profileImg = profileImg;
        this.introduction = introduction;
        this.instarId = instarId;
    }
}
