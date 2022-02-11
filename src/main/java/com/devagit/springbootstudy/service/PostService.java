package com.devagit.springbootstudy.service;

import com.devagit.springbootstudy.domain.posts.Post;
import com.devagit.springbootstudy.repository.post.PostRepository;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class PostService {
    private PostRepository postRepository;
    public void writePost(int categoryId,int subCategoryId, String userId, String title, String contents, String source) {
        Post post = new Post(categoryId,subCategoryId,userId,title,contents,source);
        postRepository.save(post);

    }
}
