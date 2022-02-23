package com.devagit.springbootstudy.repository.comment;

import com.devagit.springbootstudy.domain.comment.Comment;
import com.devagit.springbootstudy.domain.post.Post;
import com.devagit.springbootstudy.view.comment.CommentView;

import java.util.List;

public interface CommentRepository {

    Comment save(Comment comment);

}
