package com.devagit.springbootstudy.request.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.sql.Timestamp;


@Getter
@NoArgsConstructor
public class CommentRequest {
    @Nullable //달아야함
    private Integer parentId;
    private int postId;
    private int sorts;
    private String userId;
    private String content;

    public CommentRequest(@Nullable int parentId, int postId, String userId, String content, int sorts) {
        this.parentId = parentId;
        this.sorts = sorts;
        this.postId = postId;
        this.userId = userId;
        this.content = content;
    }
}
