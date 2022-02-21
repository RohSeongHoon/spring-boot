package com.devagit.springbootstudy.controller;

import com.devagit.springbootstudy.domain.post.Post;
import com.devagit.springbootstudy.request.post.DeletePostById;
import com.devagit.springbootstudy.request.post.UpdateRequest;
import com.devagit.springbootstudy.request.post.WritePostRequest;
import com.devagit.springbootstudy.service.PostService;
import com.devagit.springbootstudy.view.post.PostListView;
import com.devagit.springbootstudy.view.post.PostView;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
public class PostController {
    private PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("api/v1/posts")
    public int addPost(@RequestBody WritePostRequest req) {
        return postService.addPost(req.getCategoryId(), req.getSubCategoryId(), req.getUserId(), req.getTitle(), req.getContents(), req.getSource());
    }

    @GetMapping("api/v1/posts")
    public PostView getPost(@RequestParam(required = false) int id) {
        return postService.getPost(id);
    }

    @GetMapping("api/v1/posts/list")
    public List<PostListView> getPostList(@RequestParam(required = false) int subCategoryId, Date postCursor, int page, Integer size) {
        return postService.getPostList(subCategoryId,postCursor,page,size);
    }

    @GetMapping("api/v1/posts/find")
    public List<PostListView> findPostsByUserId(@RequestParam(required = false) String userId) {
        return postService.findPostsByUserId(userId);
    }

    @DeleteMapping("api/v1/posts")
    public void deletePost(@RequestBody DeletePostById req) {
        postService.deletePostById(req.getId(),req.getUserId());
    }

    @PutMapping("api/v1/posts")
    public int updatePost(@RequestBody UpdateRequest req) {
        return postService.updatePost(req.getId(), req.getSubCategoryId(), req.getUserId(), req.getTitle(), req.getContents(), req.getSource(),req.getCreateAt());
    }


}

