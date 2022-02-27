package com.devagit.springbootstudy.repository.comment;

import com.devagit.springbootstudy.domain.comment.Comment;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.util.List;

public interface CommentRepository {

    Comment save(Comment comment);


    List<Comment> findByPostIdAndCreatedAtLessThanEqualOrderBySortsAsc(int postIdr, Timestamp commentCursor, Pageable pageable);

    long countByParentId(int parentId);

    long deleteCommentsById(int id);

    void deleteCommentsByPostId(int postId);

    Comment findById(int id);
}
