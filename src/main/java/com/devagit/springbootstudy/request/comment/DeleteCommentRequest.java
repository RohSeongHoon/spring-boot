package com.devagit.springbootstudy.request.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeleteCommentRequest {
    private int id;
    private String userId;

    public DeleteCommentRequest(int id, String userId) {
        this.id = id;
        this.userId = userId;
    }
}
