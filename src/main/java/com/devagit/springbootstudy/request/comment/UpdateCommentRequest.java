package com.devagit.springbootstudy.request.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UpdateCommentRequest {
    private int id;
    private String userId;
    private String content;
    private LocalDateTime createdAt;

    public UpdateCommentRequest(int id,String userId, String content, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.createdAt = createdAt;
    }
}
