package com.devagit.springbootstudy.service;

import com.devagit.springbootstudy.domain.posts.Post;
import com.devagit.springbootstudy.repository.post.PostRepository;
import com.devagit.springbootstudy.view.post.PostView;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void addPost(int categoryId, int subCategoryId, String userId, String title, String contents, String source) {
        long time = System.currentTimeMillis();
        SimpleDateFormat simpl = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");
        String writeDate = simpl.format(time);
        Post post = Post.builder()
                .categoryId(categoryId)
                .subCategoryId(subCategoryId)
                .userId(userId)
                .title(title)
                .contents(contents)
                .source(source)
                .writeDate(writeDate)
                .build();
        postRepository.save(post);
    }

    public PostView getPost(int id) {
        Post post = postRepository.findById(id);
        return PostView.from(post);
    }

    public List<PostView> getPostList(int subCategoryId) {
        return postRepository.findAll()
                .stream()
                .filter(post -> post.getSubCategoryId() == subCategoryId)
                .sorted(Comparator.comparing(Post::getWriteDate))
                .map(PostView::postList)
                .collect(Collectors.toList());

    }
}
