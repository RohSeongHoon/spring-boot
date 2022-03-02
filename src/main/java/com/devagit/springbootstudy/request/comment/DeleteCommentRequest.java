package com.devagit.springbootstudy.request.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeleteCommentRequest {
    private long id;
    private String userId;

    public DeleteCommentRequest(long id, String userId) {
        this.id = id;
        this.userId = userId;
    }
}
