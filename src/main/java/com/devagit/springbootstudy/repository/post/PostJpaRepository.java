package com.devagit.springbootstudy.repository.post;

import com.devagit.springbootstudy.domain.posts.Post;
import com.devagit.springbootstudy.view.post.PostView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post,Integer> {
    Post findById(int id);

    List<Post> findAll();
}
