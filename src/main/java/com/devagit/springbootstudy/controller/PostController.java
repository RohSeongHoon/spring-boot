package com.devagit.springbootstudy.controller;

import com.devagit.springbootstudy.request.post.WritePostRequest;
import com.devagit.springbootstudy.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class PostController {
    private PostService postService;

    @PostMapping("api/v1/posts")
    public void writePost(@RequestBody WritePostRequest req) {
        postService.writePost(req.getCategoryId(), req.getSubCategoryId(), req.getUserId(), req.getTitle(), req.getContents(), req.getSource());
    }

//    @GetMapping("api/v1/posts")
//    public PostView getPost(@RequestParam(required = false)){
//    }
}
