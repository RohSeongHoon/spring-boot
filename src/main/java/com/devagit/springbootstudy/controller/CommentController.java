package com.devagit.springbootstudy.controller;

import com.devagit.springbootstudy.request.comment.CommentRequest;
import com.devagit.springbootstudy.request.comment.DeleteCommentRequest;
import com.devagit.springbootstudy.request.comment.UpdateCommentRequest;
import com.devagit.springbootstudy.service.CommentService;
import com.devagit.springbootstudy.view.comment.CommentView;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;

@RestController
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //Nullable어노테이션을 붙여야함 integer
    @PostMapping("/api/v1/comments")
    public CommentView addComment(@RequestBody CommentRequest req) {
        return commentService.addComment(req.getParentId(), req.getPostId(), req.getUserId(), req.getContent(), req.getSorts());
    }

    @GetMapping("/api/v1/comments/list")
    public List<CommentView> getCommentsList(@RequestParam int postId, @Nullable LocalDateTime commentCursor, int page, int size) {
        return commentService.getCommentsList(postId, commentCursor, page, size);
    }
    @DeleteMapping("/api/v1/comments")
    public long deleteComment(@RequestBody DeleteCommentRequest req) {
        return commentService.deleteComment(req.getId(), req.getUserId());
    }
    @PutMapping("/api/v1/comments")
    public CommentView updateComments(@RequestParam UpdateCommentRequest req) {
        return commentService.updateComments(req.getId(), req.getUserId(), req.getContent(), req.getCreatedAt());
    }
}
