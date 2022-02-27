package com.devagit.springbootstudy.repository.comment;

import com.devagit.springbootstudy.domain.comment.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface CommentJpaRepository extends JpaRepository<Comment, Integer> {

    Comment save(Comment comment);

    List<Comment> findByPostIdAndCreatedAtLessThanEqualOrderBySortsAsc(int postId, Timestamp commentCursor, Pageable pageable);

    long countByParentId(int parentId);

    long deleteCommentsById(int id);

    void deleteCommentsByPostId(int postId);

    Comment findById(int id);
}
