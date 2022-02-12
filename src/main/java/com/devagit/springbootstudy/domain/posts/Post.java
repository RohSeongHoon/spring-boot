package com.devagit.springbootstudy.domain.posts;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "INT", nullable = false, unique = true)
    private int id;
    @Column(columnDefinition = "INT", nullable = false)
    private int categoryId;
    @Column(columnDefinition = "INT", nullable = false)
    private int subCategoryId;
    @Column(columnDefinition = "VARCHAR(32)", nullable = false)
    private String userId;
    @Column(columnDefinition = "VARCHAR(128)", nullable = false)
    private String title;
    @Column(columnDefinition = "VARCHAR(1024)", nullable = false)
    private String contents;
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP",nullable = true)
    private String writeDate;
    @Column(columnDefinition = "VARCHAR(64)", nullable = true)
    private String source;

    @Builder
    public Post(int categoryId, int subCategoryId, String userId, String title, String contents, String source,String writeDate) {
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
        this.source = source;
        this.writeDate = writeDate;
    }

}

