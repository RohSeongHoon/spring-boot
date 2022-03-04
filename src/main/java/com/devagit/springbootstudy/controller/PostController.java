package com.devagit.springbootstudy.controller;

import com.devagit.springbootstudy.request.post.DeletePostById;
import com.devagit.springbootstudy.request.post.UpdateRequest;
import com.devagit.springbootstudy.request.post.addPostRequest;
import com.devagit.springbootstudy.service.PostService;
import com.devagit.springbootstudy.util.Page;
import com.devagit.springbootstudy.view.post.PostListView;
import com.devagit.springbootstudy.view.post.PostView;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


@RestController
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("api/v1/posts")
    public long addPost(@RequestBody addPostRequest req) {
        return postService.addPost(req.getCategoryId(), req.getSubCategoryId(), req.getUserId(), req.getTitle(), req.getContents(), req.getSource());
    }

    @GetMapping("api/v1/posts")
    public PostView getPost(@RequestParam(required = false) long id) {
        return postService.getPost(id);
    }

    @GetMapping("api/v1/posts/list")
    public Page<PostListView> getPostList(@RequestParam(required = false) int subCategoryId, @Nullable LocalDateTime postCursor, int page, @Nullable int size) {
        return postService.getPostList(subCategoryId, postCursor, page, size);
    }

    @GetMapping("api/v1/posts/find")
    public List<PostListView> findPostsByUserId(@RequestParam String userId) {
        return postService.findPostsByUserId(userId);
    }

    @DeleteMapping("api/v1/posts")
    public void deletePost(@RequestBody DeletePostById req) {
        postService.deletePostById(req.getId(), req.getUserId());
    }

    @PutMapping("api/v1/posts")
    public long updatePost(@RequestBody UpdateRequest req) {
        return postService.updatePost(req.getId(), req.getSubCategoryId(), req.getUserId(), req.getTitle(), req.getContents(), req.getSource(), req.getCreatedAt());
    }

    @GetMapping("api/v1/posts/search")
    public List<PostListView> findPostsByTitle(@RequestParam(required = false) String keyword,LocalDateTime searchCursor, int page,@Nullable int size) {
        return postService.findPostsByTitle(keyword, searchCursor, page, size);
    }
    @GetMapping("api/v1/posts/likedPost")
    public Page<PostListView> test(@RequestParam(required = false)String userId){
        return postService.getLikedPost(userId);
    }


}

