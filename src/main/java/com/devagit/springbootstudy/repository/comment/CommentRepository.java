package com.devagit.springbootstudy.repository.comment;

import com.devagit.springbootstudy.domain.comment.Comment;
import com.devagit.springbootstudy.domain.post.Post;
import com.devagit.springbootstudy.view.comment.CommentView;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface CommentRepository {

    Comment save(Comment comment);

    List<Comment> findByPostId(int postIdr, Pageable pageable);

    List<Comment> findAllByPostId(int postId,Pageable pageable);

    long countByParentId(int parentId);

    long deleteCommentsById(int id);

    void deleteCommentsByPostId(int postId);

    Comment findById(int id);
}
