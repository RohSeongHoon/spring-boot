package com.devagit.springbootstudy.service;

import com.devagit.springbootstudy.domain.comment.Comment;
import com.devagit.springbootstudy.repository.comment.CommentRepository;
import com.devagit.springbootstudy.view.comment.CommentView;
import org.springframework.stereotype.Service;



@Service
public class CommentService {
    private CommentRepository commentRepository;


    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentView addComment(int postId, String userId, String content) {
        Comment comment = new Comment(postId,userId,content);
        return CommentView.from(commentRepository.save(comment));
    }


}
