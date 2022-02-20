package com.devagit.springbootstudy.repository.post;

import com.devagit.springbootstudy.domain.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Date;
import java.util.List;

public interface PostRepository {

    Post save(Post post);

    Post findById(int id);

    List<Post> findAll();

    List<Post> findByUserId(String userId);

    void deletePostById(int id);

    List<Post> findBySubCategoryIdOrderByIdDesc(int subCategoryId,Pageable page);

//    List<Post> findBySubCategoryIdAndCreatedAtLessThanEqualOrderByCreatedAtDesc(int subCategoryId, Pageable page, Date createAt);

}
