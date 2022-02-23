package com.devagit.springbootstudy.view.comment;

import com.devagit.springbootstudy.domain.comment.Comment;
import com.devagit.springbootstudy.domain.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class CommentView {
    private int postId;
    private String userName;
    private String content;
    private Date createdAt;

    public CommentView(int postId, String userId, String content, Date createdAt) {
        this.postId = postId;
        this.userName = userId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public static CommentView from(Comment comment){
        return new CommentView(comment.getPostId(), comment.getUserId(), comment.getContent(), comment.getCreatedAt());
    }
}
