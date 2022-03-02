package com.devagit.springbootstudy.repository.post;

import com.devagit.springbootstudy.domain.Post;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
    public Post findById(long id) {
        return postJpaRepository.findById(id);
    }

    @Override
    public List<Post> findByUserId(String userId) {
        return postJpaRepository.findByUserId(userId);
    }

    @Override
    public void deletePostById(long id) {
        postJpaRepository.deletePostById(id);
    }

    @Override
    public List<Post> findBySubCategoryIdAndCreatedAtLessThanEqualOrderByCreatedAtDesc(int subCategoryId, LocalDateTime postCursor, Pageable page) {
        return postJpaRepository.findBySubCategoryIdAndCreatedAtLessThanEqualOrderByCreatedAtDesc(subCategoryId, postCursor, page);
    }

    @Override
    public List<Post> findByTitleContainsAndCreatedAtLessThanEqualOrderByCreatedAtDesc(String keyword, LocalDateTime searchCursor, Pageable page) {
        return postJpaRepository.findByTitleContainsAndCreatedAtLessThanEqualOrderByCreatedAtDesc(keyword, searchCursor, page);
    }

}
