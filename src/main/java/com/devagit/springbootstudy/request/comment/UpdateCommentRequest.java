package com.devagit.springbootstudy.request.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@NoArgsConstructor
public class UpdateCommentRequest {
    private int id;
    private String userId;
    private String content;
    private Timestamp createdAt;

    public UpdateCommentRequest(int id,String userId, String content, Timestamp createdAt) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.createdAt = createdAt;
    }
}
