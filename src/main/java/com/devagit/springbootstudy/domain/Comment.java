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
    private long id;
    @Nullable
    @Column(columnDefinition = "long default 0")
    private long parentId;
    @Column(columnDefinition = "long", nullable = false)
    private long postId;
    @Column(columnDefinition = "VARCHAR(32)", nullable = false)
    private String userId;
    @Column(columnDefinition = "VARCHAR(32)", nullable = false)
    private String content;
    @Column(columnDefinition = "long default 0")
    private long sorts;
    @CreationTimestamp
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt; //dateTime으로 변경
    @CreationTimestamp
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;


    @Builder
    public Comment(long postId, long parentId,long sorts, String userId, String content) {
        this.sorts = sorts;
        this.parentId = parentId;
        this.postId = postId;
        this.userId = userId;
        this.content = content;


    }
}
