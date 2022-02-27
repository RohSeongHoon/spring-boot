package com.devagit.springbootstudy.service;

import com.devagit.springbootstudy.domain.comment.Comment;
import com.devagit.springbootstudy.exceptionHandler.NotFoundException;
import com.devagit.springbootstudy.repository.comment.CommentRepository;
import com.devagit.springbootstudy.util.MakePageAble;
import com.devagit.springbootstudy.view.comment.CommentView;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.devagit.springbootstudy.util.MakePageAble.currentTime;


@Service
public class CommentService {
    private CommentRepository commentRepository;


    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentView addComment(int parentId, int postId, String userId, String content, int sorts) {
        Comment comment = Comment.builder()
                .parentId(parentId)
                .postId(postId)
                .userId(userId)
                .content(content)
                .sorts(sorts)
                .build();
        return CommentView.from(commentRepository.save(comment));
    }


    public List<CommentView> getCommentsList(int postId, Timestamp commentCursor, int page, int size) {
        if (commentCursor == null) {
            commentCursor = currentTime;
        }
        Pageable pageable = MakePageAble.makePageAble(page, size);
        return commentRepository.findByPostIdAndCreatedAtLessThanEqualOrderBySortsAsc(postId, commentCursor, pageable)
                .stream()
                .map(CommentView::from)
                .collect(Collectors.toList());

    }

    public long deleteComment(int id, String userId) {
        Comment comment = Optional.ofNullable(commentRepository.findById(id)).orElseThrow(() -> new NotFoundException("없는 정보입니다"));
        if (!userId.equals(comment.getUserId())) {
            throw new NotFoundException("정보가 일치하지 않습니다");
        }
        long count = commentRepository.countByParentId(id);
        if (count != 0) {
            return count;
        }
        commentRepository.deleteCommentsById(id);
        return 0;
    }

    public CommentView updateComments(int id, String userId, String content, Timestamp createdAt) {
        Comment comment = Optional.ofNullable(commentRepository.findById(id)).orElseThrow(() -> new NotFoundException("없는 정보입니다"));
        if (!userId.equals(comment.getUserId())) {
            throw new NotFoundException("정보가 일치하지 않습니다");
        }
        comment.setContent(content);
        comment.setCreatedAt(createdAt);
        commentRepository.save(comment);
        return CommentView.from(comment);
    }

}
