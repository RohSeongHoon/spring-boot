package com.devagit.springbootstudy.repository.post;

import com.devagit.springbootstudy.domain.posts.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post,Integer> {
    Post findById(int id);

    List<Post> findAll();

    List<Post> findByUserId(String userId);

    @Transactional
    void deletePostById(int id);
}
