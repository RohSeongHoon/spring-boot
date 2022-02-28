package com.devagit.springbootstudy.service;

import com.devagit.springbootstudy.domain.Comment;
import com.devagit.springbootstudy.exceptionHandler.badrequest.CommentBadRequestException;
import com.devagit.springbootstudy.exceptionHandler.notfound.CommentNotFoundException;
import com.devagit.springbootstudy.exceptionHandler.notfound.NotFoundException;
import com.devagit.springbootstudy.repository.comment.CommentRepository;
import com.devagit.springbootstudy.util.MakePageAble;
import com.devagit.springbootstudy.view.comment.CommentView;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.devagit.springbootstudy.util.MakePageAble.currentTime;


@Service
public class CommentService {
    private final CommentRepository commentRepository;


    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    @Transactional
    public CommentView addComment(@Nullable Integer parentId, int postId, String userId, String content, int sorts) {
        Comment comment = Comment.builder()
                .parentId(parentId)
                .postId(postId)
                .userId(userId)
                .content(content)
                .sorts(sorts)
                .build();
        return CommentView.from(commentRepository.save(comment));
    }


    public List<CommentView> getCommentsList(int postId,@Nullable LocalDateTime commentCursor, int page, int size) {
        if (commentCursor == null) {
            commentCursor = currentTime;
        }
        // 응답을 짤때 페이지뷰(view)로 응답을 내릴 수 이싸ㄸ
        //dateTime으로 타입변경 page로 받음 list가아닌
        Pageable pageable = MakePageAble.makePageAble(page, size);
        return commentRepository.findByPostIdAndCreatedAtLessThanEqualOrderBySortsAsc(postId, commentCursor, pageable)
                .stream()
                .map(CommentView::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public long deleteComment(int id, String userId) {
        Comment comment = Optional.ofNullable(commentRepository.findById(id)).orElseThrow(() -> new CommentNotFoundException("없는 정보입니다"));
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
    public CommentView updateComments(int id, String userId, String content, LocalDateTime createdAt) {
        Comment comment = Optional.ofNullable(commentRepository.findById(id)).orElseThrow(() -> new CommentNotFoundException("없는 정보입니다"));
        if (!userId.equals(comment.getUserId())) {
            throw new CommentBadRequestException("정보가 일치하지 않습니다");
        }
        comment.setContent(content);
        comment.setCreatedAt(createdAt);
        commentRepository.save(comment);
        return CommentView.from(comment);
    }
}
