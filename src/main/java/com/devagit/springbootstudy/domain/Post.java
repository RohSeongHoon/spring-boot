package com.devagit.springbootstudy.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "posts")
public class Post {

    @GeneratedValue
    @Id
    @Column(columnDefinition = "INT", nullable = false, unique = true)
    private long id;
    @Column(columnDefinition = "INT", nullable = false)
    private int subCategoryId;
    @Column(columnDefinition = "VARCHAR(32)", nullable = false)
    private String userId;
    @Column(columnDefinition = "VARCHAR(128)", nullable = false)
    private String title;
    @Column(columnDefinition = "VARCHAR(1024)", nullable = false)
    private String contents;
    @CreationTimestamp
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private LocalDateTime createdAt;
    @CreationTimestamp
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private LocalDateTime updatedAt;
    @Column(columnDefinition = "VARCHAR(64)")
    private String videoSource;
    @Column(columnDefinition = "VARCHAR(128)")
    private String imgSource;
    @Column(columnDefinition = "INT DEFAULT 0")
    private long commentCnt;
    @Column(columnDefinition = "INT DEFAULT 0")
    private  long heartCnt;

    @Builder
    public Post( int subCategoryId, String userId, String title, String contents,String videoSource, String imgSource,long commentCnt,long heartCnt) {
        this.subCategoryId = subCategoryId;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
        this.videoSource = videoSource;
        this.imgSource = imgSource;
        this.commentCnt = commentCnt;
        this.heartCnt = heartCnt;

    }
}

