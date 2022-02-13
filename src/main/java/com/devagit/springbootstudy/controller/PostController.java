package com.devagit.springbootstudy.controller;

import com.devagit.springbootstudy.request.post.WritePostRequest;
import com.devagit.springbootstudy.service.PostService;
import com.devagit.springbootstudy.view.post.PostView;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("api/v1/posts")
    public void writePost(@RequestBody WritePostRequest req) {
        postService.addPost(req.getCategoryId(), req.getSubCategoryId(), req.getUserId(), req.getTitle(), req.getContents(), req.getSource());
    }

    @GetMapping("api/v1/posts")
    public PostView getPost(@RequestParam(required = false) int id) {
        return postService.getPost(id);
    }

    @GetMapping("api/v1/posts/list")
    public List<PostView> getPostList(@RequestParam(required = false) int subCategoryId) {
        return postService.getPostList(subCategoryId);
    }
}

