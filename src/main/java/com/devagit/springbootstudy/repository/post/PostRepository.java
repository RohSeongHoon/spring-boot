package com.devagit.springbootstudy.repository.post;

import com.devagit.springbootstudy.domain.posts.Post;
import com.devagit.springbootstudy.view.post.PostView;

import java.util.List;

public interface PostRepository {

    Post save(Post post);

    Post findById(int id);

    List<Post> findAll();
}
