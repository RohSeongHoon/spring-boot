package com.devagit.springbootstudy.domain.comment;

import com.devagit.springbootstudy.domain.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "comments")
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "post_id",columnDefinition = "int", nullable = false)
    private int postId;
    @Column(columnDefinition = "VARCHAR(32)", nullable = false)
    private String userId;
    @Column(columnDefinition = "VARCHAR(32)", nullable = false)
    private String content;
    @CreationTimestamp
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;




    public Comment(int postId, String userId, String content) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
    }
}
