package com.devagit.springbootstudy.repository.comment;

import com.devagit.springbootstudy.domain.Comment;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CommentRepository {

    Comment save(Comment comment);


    List<Comment> findByPostIdAndCreatedAtLessThanEqualOrderBySortsAsc(long postIdr, LocalDateTime commentCursor, Pageable pageable);

    long countByParentId(long parentId);

    long deleteCommentsById(long id);

    void deleteCommentsByPostId(long postId);

    Optional<Comment> findById(long id);

    List<Comment> findByUserId(String userId);
}
