package com.devagit.springbootstudy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "hearts")
public class Heart {

    @GeneratedValue
    @Id
    private long id;
    @Column(columnDefinition = "INT", nullable = false)
    private long postId;
    @Column(columnDefinition = "VARCHAR(32)", nullable = false)
    private String userId;

    public Heart(long postId, String userId) {
        this.postId = postId;
        this.userId = userId;
    }
}
