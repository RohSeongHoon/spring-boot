package com.devagit.springbootstudy.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", indexes = {
        @Index(name = "UNQ_USER_USERNAME", columnList = "username", unique = true)
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
    @Column(columnDefinition = "VARCHAR(256)", nullable = false)
    private String password;
    @Column(columnDefinition = "VARCHAR(20)", nullable = true)
    private String phoneNumber;

    public User(String username, String userId, String password, String phoneNumber) {
        this.username = username;
        this.userId = userId;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
