package com.devagit.springbootstudy.service;

import com.devagit.springbootstudy.domain.comment.Comment;
import com.devagit.springbootstudy.repository.comment.CommentRepository;
import com.devagit.springbootstudy.util.MakePageAble;
import com.devagit.springbootstudy.view.comment.CommentView;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommentService {
    private CommentRepository commentRepository;


    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentView addComment(int parentId,int postId, String userId, String content,int sorts) {
        Comment comment = Comment.builder()
                .parentId(parentId)
                .postId(postId)
                .userId(userId)
                .content(content)
                .sorts(sorts)
                .build();
        return CommentView.from(commentRepository.save(comment));
    }


    public List<CommentView> getCommentsList(int postId, Date commentCursor, int page,int size) {
        if (size == 0) {
            size = MakePageAble.DEFAULT_SIZE;
        }
        if (commentCursor  == null){
            Date now = new Date();
            commentCursor = now;
        }
       Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC,"sorts","parentId","createdAt");
        return commentRepository.findAllByPostId(postId,pageable)
                .stream()
                .map(CommentView::from)
                .collect(Collectors.toList());

    }
}
