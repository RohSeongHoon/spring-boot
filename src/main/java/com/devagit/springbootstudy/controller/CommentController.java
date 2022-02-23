package com.devagit.springbootstudy.controller;

import com.devagit.springbootstudy.domain.post.Post;
import com.devagit.springbootstudy.request.comment.CommentRequest;
import com.devagit.springbootstudy.service.CommentService;
import com.devagit.springbootstudy.view.comment.CommentView;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("api/v1/comments")
    public CommentView addComment(@RequestBody CommentRequest req){
        return commentService.addComment(req.getPostId(), req.getUserId(), req.getContent());
    }


}
