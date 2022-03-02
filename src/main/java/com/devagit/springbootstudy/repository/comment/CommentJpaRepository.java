package com.devagit.springbootstudy.repository.comment;

import com.devagit.springbootstudy.domain.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CommentJpaRepository extends JpaRepository<Comment, Long> {

    Comment save(Comment comment);

    List<Comment> findByPostIdAndCreatedAtLessThanEqualOrderBySortsAsc(long postId, LocalDateTime commentCursor, Pageable pageable);

    Optional<Long> countByParentId(long parentId);

    long deleteCommentsById(long id);

    void deleteCommentsByPostId(long postId);

    Optional<Comment> findById(long id);

    List<Comment> findByUserId(String userId);
}
