package com.devagit.springbootstudy.request.comment;

import com.devagit.springbootstudy.domain.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class CommentRequest {
    private int postId;
    private String userId;
    private String content;

    public CommentRequest(int postId, String userId, String content) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
    }
}
