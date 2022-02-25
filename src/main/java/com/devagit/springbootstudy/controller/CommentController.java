package com.devagit.springbootstudy.controller;

import com.devagit.springbootstudy.request.comment.CommentRequest;
import com.devagit.springbootstudy.service.CommentService;
import com.devagit.springbootstudy.view.comment.CommentView;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("api/v1/comments")
    public CommentView addComment(@RequestBody CommentRequest req){
        return commentService.addComment(req.getParentId(),req.getPostId(), req.getUserId(), req.getContent(),req.getSorts());
    }
    @GetMapping("api/v1/comments/list")
    public List<CommentView> getCommentsList(@RequestParam int postId, Date commentCursor, int page, int size){
        return commentService.getCommentsList(postId,commentCursor,page,size);
    }


}
