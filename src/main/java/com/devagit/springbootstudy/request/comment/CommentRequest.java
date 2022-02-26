package com.devagit.springbootstudy.request.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Getter
@NoArgsConstructor
public class CommentRequest {
    private int parentId;
    private int postId;
    private int sorts;
    private String userId;
    private String content;

    public CommentRequest(int parentId, int postId, String userId, String content, int sorts) {
        this.parentId = parentId;
        this.sorts = sorts;
        this.postId = postId;
        this.userId = userId;
        this.content = content;
    }
}
