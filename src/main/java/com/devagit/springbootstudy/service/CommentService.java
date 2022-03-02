package com.devagit.springbootstudy.service;

import com.devagit.springbootstudy.domain.Comment;
import com.devagit.springbootstudy.exceptionHandler.badrequest.CommentBadRequestException;
import com.devagit.springbootstudy.exceptionHandler.notfound.CommentNotFoundException;
import com.devagit.springbootstudy.repository.comment.CommentRepository;
import com.devagit.springbootstudy.view.comment.CommentView;
import org.springframework.data.domain.PageRequest;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
public class CommentService {
    private final CommentRepository commentRepository;


    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Transactional
    public CommentView addComment(@Nullable Integer parentId, long postId, String userId, String content, int sorts) {
        Comment comment = Comment.builder()
                .parentId(parentId)
                .postId(postId)
                .userId(userId)
                .content(content)
                .sorts(sorts)
                .build();
        return CommentView.from(commentRepository.save(comment));
    }


    public List<CommentView> getCommentsList(long postId, @Nullable LocalDateTime commentCursor, int page, int size) {
        if (commentCursor == null) {
            commentCursor = LocalDateTime.now();
        }
        // 응답을 짤때 페이지뷰(view)로 응답을 내릴 수 이싸ㄸ
        //dateTime으로 타입변경 page로 받음 list가아닌
        return commentRepository.findByPostIdAndCreatedAtLessThanEqualOrderBySortsAsc(postId, commentCursor, PageRequest.of(page, size))
                .stream()
                .map(CommentView::from)
                .collect(Collectors.toList());
    }

    public List<CommentView> getCommentsByUserId(String userId) {
        return Optional.ofNullable(commentRepository.findByUserId(userId)).orElseThrow(CommentNotFoundException::new)
                .stream()
                .map(CommentView::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public long deleteComment(long id, String userId) {
        Comment comment = commentRepository.findById(id).orElseThrow(CommentNotFoundException::new);
        if (!userId.equals(comment.getUserId())) {
            throw new CommentBadRequestException("정보가 일치하지 않습니다");
        }//badrequest
        long count = commentRepository.countByParentId(id);
        if (count != 0) {
            return count;
        }
        commentRepository.deleteCommentsById(id);
        return 0;
    }

    @Transactional
    public CommentView updateComments(long id, String userId, String content, LocalDateTime createdAt) {
        Comment comment = commentRepository.findById(id).orElseThrow(CommentNotFoundException::new);
        if (!userId.equals(comment.getUserId())) {
            throw new CommentBadRequestException("정보가 일치하지 않습니다");
        }
        comment.setContent(content);
        comment.setCreatedAt(createdAt);
        commentRepository.save(comment);
        return CommentView.from(comment);
    }
}
