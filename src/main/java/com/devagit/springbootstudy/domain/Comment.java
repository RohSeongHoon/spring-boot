package com.devagit.springbootstudy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "comments")
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private int id;
    @Nullable
    @Column(columnDefinition = "int default 0")
    private Integer parentId;
    @Column(columnDefinition = "int", nullable = false)
    private int postId;
    @Column(columnDefinition = "VARCHAR(32)", nullable = false)
    private String userId;
    @Column(columnDefinition = "VARCHAR(32)", nullable = false)
    private String content;
    @Column(columnDefinition = "int default 0")
    private int sorts;
    @CreationTimestamp
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt; //dateTime으로 변경
    @CreationTimestamp
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;


    @Builder
    public Comment(int postId, int parentId, int sorts, String userId, String content) {
        this.sorts = sorts;
        this.parentId = parentId;
        this.postId = postId;
        this.userId = userId;
        this.content = content;


    }
}
