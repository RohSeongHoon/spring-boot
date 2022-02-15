package com.devagit.springbootstudy.repository.post;

import com.devagit.springbootstudy.domain.post.Post;

import java.util.List;

public interface PostRepository {

    Post save(Post post);

    Post findById(int id);

    List<Post> findAll();

    List<Post> findByUserId(String userId);

    void deletePostById(int id);
}
