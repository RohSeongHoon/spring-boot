package com.devagit.springbootstudy.repository.post;

import com.devagit.springbootstudy.domain.Heart;
import com.devagit.springbootstudy.domain.Post;
import org.springframework.data.domain.Pageable;


import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository {

    Post save(Post post);

    Post findById(long id);

    List<Post> findByUserId(String userId);

    void deletePostById(long id);

    List<Post> findBySubCategoryIdAndCreatedAtLessThanEqualOrderByCreatedAtDesc(int subCategoryId, LocalDateTime postCursor, Pageable page);

    List<Post> findByTitleContainsAndCreatedAtLessThanEqualOrderByCreatedAtDesc(String keyword, LocalDateTime searchCursor, Pageable page);

    List<Post> findByIdIn(List<Long> hearts);
}
