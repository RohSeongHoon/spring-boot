package com.devagit.springbootstudy.repository.comment;

import com.devagit.springbootstudy.domain.comment.Comment;

import com.devagit.springbootstudy.domain.post.Post;
import com.devagit.springbootstudy.view.comment.CommentView;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepositoryImpl implements CommentRepository{
    private CommentJpaRepository commentJpaRepository;

    public CommentRepositoryImpl(CommentJpaRepository commentJpaRepository) {
        this.commentJpaRepository = commentJpaRepository;
    }

    @Override
    public Comment save(Comment comment) {
        return commentJpaRepository.save(comment);
    }


}
