package com.devagit.springbootstudy.repository.comment;

import com.devagit.springbootstudy.domain.Comment;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface CommentRepository {

    Comment save(Comment comment);


    List<Comment> findByPostIdAndCreatedAtLessThanEqualOrderBySortsAsc(int postIdr, LocalDateTime commentCursor, Pageable pageable);

    long countByParentId(int parentId);

    long deleteCommentsById(int id);

    void deleteCommentsByPostId(int postId);

    Comment findById(int id);
}
