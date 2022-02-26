package com.devagit.springbootstudy.domain.likes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
public class Like {
    @Id
    @GeneratedValue
    private int id;
    @Column(columnDefinition = "INT")
    private int postId;
    @Column(columnDefinition = "VARCHAR(32)",nullable = false)
    private String userId;

    public Like(int postId, String userId) {
        this.postId = postId;
        this.userId = userId;
    }
}
