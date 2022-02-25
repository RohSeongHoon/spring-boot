package com.devagit.springbootstudy.domain.post;


import com.devagit.springbootstudy.domain.comment.Comment;
import com.devagit.springbootstudy.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "posts")
public class Post {

    @GeneratedValue
    @Id
    @Column(columnDefinition = "INT", nullable = false, unique = true)
    private int id;
    @Column(columnDefinition = "INT", nullable = false)
    private int categoryId;
    @Column(columnDefinition = "INT", nullable = false)
    private int subCategoryId;
    @Column(columnDefinition = "VARCHAR(32)",nullable = false)
    private String userId;
    @Column(columnDefinition = "VARCHAR(128)", nullable = false)
    private String title;
    @Column(columnDefinition = "VARCHAR(1024)", nullable = false)
    private String contents;
    @CreationTimestamp
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private Date createdAt;
    @CreationTimestamp
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP", nullable = true)
    private Date updatedAt;
    @Column(columnDefinition = "VARCHAR(64)")
    private String source;

    @Builder
    public Post(int categoryId, int subCategoryId,String userId, String title, String contents, String source) {
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
        this.source = source;

    }
}

