package com.devagit.springbootstudy.repository.comment;

import com.devagit.springbootstudy.domain.Comment;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class CommentRepositoryImpl implements CommentRepository {
    private CommentJpaRepository commentJpaRepository;

    public CommentRepositoryImpl(CommentJpaRepository commentJpaRepository) {
        this.commentJpaRepository = commentJpaRepository;
    }

    @Override
    public Optional<Comment> save(Comment comment) {
        return commentJpaRepository.save(comment);
    }

    @Override
    public List<Comment> findByPostIdAndCreatedAtLessThanEqualOrderBySortsAsc(long postId, LocalDateTime commentCursor, Pageable pageable) {
        return commentJpaRepository.findByPostIdAndCreatedAtLessThanEqualOrderBySortsAsc(postId, commentCursor, pageable);
    }

    @Override
    public long countByParentId(long parentId) {
        return commentJpaRepository.countByParentId(parentId);
    }

    @Override
    public long deleteCommentsById(long id) {
        return commentJpaRepository.deleteCommentsById(id);
    }

    @Override
    public void deleteCommentsByPostId(long postId) {
        commentJpaRepository.deleteCommentsByPostId(postId);
    }

    @Override
    public Optional<Comment> findById(long id) {
        return commentJpaRepository.findById(id);
    }

    @Override
    public List<Comment> findByUserId(String userId) {
        return commentJpaRepository.findByUserId(userId);
    }


}
