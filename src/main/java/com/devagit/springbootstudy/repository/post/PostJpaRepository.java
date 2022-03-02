package com.devagit.springbootstudy.repository.post;

import com.devagit.springbootstudy.domain.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
    Post findById(long id);

    List<Post> findByUserId(String userId);

    @Transactional
    void deletePostById(long id);

    List<Post> findBySubCategoryIdAndCreatedAtLessThanEqualOrderByCreatedAtDesc(int subCategoryId, LocalDateTime postCursor, Pageable page);

    List<Post> findByTitleContainsAndCreatedAtLessThanEqualOrderByCreatedAtDesc(String keyword, LocalDateTime searchCursor, Pageable page);
}
