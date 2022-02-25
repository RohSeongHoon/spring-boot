package com.devagit.springbootstudy.repository.comment;

import com.devagit.springbootstudy.domain.comment.Comment;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    @Override
    public List<Comment> findByPostId(int postIdr, Pageable pageable) {
        return null;
    }

    @Override
    public List<Comment> findAllByPostId(int postId,Pageable pageable) {
       return commentJpaRepository.findAllByPostId(postId,pageable);
    }




}
