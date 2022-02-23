package com.devagit.springbootstudy.repository.comment;

import com.devagit.springbootstudy.domain.comment.Comment;
import com.devagit.springbootstudy.domain.post.Post;
import com.devagit.springbootstudy.view.comment.CommentView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentJpaRepository extends JpaRepository<Comment,Integer> {

    Comment save(Comment comment);


}
