package com.devagit.springbootstudy.repository.comment;

import com.devagit.springbootstudy.domain.comment.Comment;
import com.devagit.springbootstudy.domain.post.Post;
import com.devagit.springbootstudy.view.comment.CommentView;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CommentJpaRepository extends JpaRepository<Comment,Integer> {

    Comment save(Comment comment);


    List<Comment> findByPostId(int postId, Pageable pageable);

    List<Comment> findAllByPostId(int postId,Pageable pageable);

    long countByParentId(int parentId);

    long deleteCommentsById(int id);

    void deleteCommentsByPostId(int postId);

    Comment findById(int id);
}
