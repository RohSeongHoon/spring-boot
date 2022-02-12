package com.devagit.springbootstudy.repository.post;

import com.devagit.springbootstudy.domain.posts.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<Post,Integer> {
    Post findById(int id);
}
