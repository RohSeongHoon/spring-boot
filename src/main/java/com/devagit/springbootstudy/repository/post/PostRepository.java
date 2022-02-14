package com.devagit.springbootstudy.repository.post;

import com.devagit.springbootstudy.domain.posts.Post;
import com.devagit.springbootstudy.view.post.PostView;

import javax.transaction.Transactional;
import java.util.List;

public interface PostRepository {

    Post save(Post post);

    Post findById(int id);

    List<Post> findAll();

    List<Post> findByUserId(String userId);

    void deletePostById(int id);
}
