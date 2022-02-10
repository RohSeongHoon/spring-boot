package com.devagit.springbootstudy.domain.posts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Temporal(TemporalType.TIMESTAMP)
    private String writeDate;
    @Column(columnDefinition = "VARCHAR(64)", nullable = true)
    private String source;

    public Post(int categoryId, int subCategoryId, String userId, String title, String contents, String writeDate, String source) {
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
        this.writeDate = writeDate;
        this.source = source;
    }
}

