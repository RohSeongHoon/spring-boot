package com.devagit.springbootstudy.domain.heart;

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
    private int id;
    @Column(columnDefinition = "INT")
    private int postId;
    @Column(columnDefinition = "VARCHAR(32)", nullable = false)
    private String userId;

    public Heart(int postId, String userId) {
        this.postId = postId;
        this.userId = userId;
    }
}
