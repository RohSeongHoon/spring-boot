package com.devagit.springbootstudy.repository.post;

import com.devagit.springbootstudy.domain.posts.Post;
import com.devagit.springbootstudy.view.PostView;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepositoryImpl implements PostRepository {
    private final PostJpaRepository postJpaRepository;

    public PostRepositoryImpl(PostJpaRepository postJpaRepository) {
        this.postJpaRepository = postJpaRepository;
    }

    @Override
    public Post save(Post post) {
        return postJpaRepository.save(post);
    }

    @Override
    public Post findById(int id) {
        return postJpaRepository.findById(id);
    }
}
