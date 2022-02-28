package com.devagit.springbootstudy.repository.comment;

import com.devagit.springbootstudy.domain.Comment;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class CommentRepositoryImpl implements CommentRepository {
    private CommentJpaRepository commentJpaRepository;

    public CommentRepositoryImpl(CommentJpaRepository commentJpaRepository) {
        this.commentJpaRepository = commentJpaRepository;
    }

    @Override
    public Comment save(Comment comment) {
        return commentJpaRepository.save(comment);
    }

    @Override
    public List<Comment> findByPostIdAndCreatedAtLessThanEqualOrderBySortsAsc(int postId, LocalDateTime commentCursor, Pageable pageable) {
        return commentJpaRepository.findByPostIdAndCreatedAtLessThanEqualOrderBySortsAsc(postId, commentCursor, pageable);
    }

    @Override
    public long countByParentId(int parentId) {
        return commentJpaRepository.countByParentId(parentId);
    }

    @Override
    public long deleteCommentsById(int id) {
        return commentJpaRepository.deleteCommentsById(id);
    }

    @Override
    public void deleteCommentsByPostId(int postId) {
        commentJpaRepository.deleteCommentsByPostId(postId);
    }

    @Override
    public Comment findById(int id) {
        return commentJpaRepository.findById(id);
    }


}
