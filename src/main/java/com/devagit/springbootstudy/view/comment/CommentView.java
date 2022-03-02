package com.devagit.springbootstudy.view.comment;

import com.devagit.springbootstudy.domain.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@NoArgsConstructor
public class CommentView {
    private int parentId;
    private long postId;
    private String userName;
    private String content;
    private LocalDateTime createdAt;

    public CommentView( long postId, String userId, String content,LocalDateTime createdAt) {
        this.postId = postId;
        this.userName = userId;
        this.content = content;
        this.createdAt = createdAt;

    }

    public static CommentView from(Comment comment) {
        return new CommentView( comment.getPostId(), comment.getUserId(), comment.getContent(), comment.getCreatedAt());
    }
}
