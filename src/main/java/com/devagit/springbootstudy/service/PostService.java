package com.devagit.springbootstudy.service;


import com.devagit.springbootstudy.domain.post.Post;
import com.devagit.springbootstudy.exceptionHandler.NotFoundException;
import com.devagit.springbootstudy.repository.post.PostRepository;
import com.devagit.springbootstudy.util.MakePageAble;
import com.devagit.springbootstudy.view.post.PostListView;
import com.devagit.springbootstudy.view.post.PostView;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.devagit.springbootstudy.util.MakePageAble.currentTime;


@Service
public class PostService {
    private final PostRepository postRepository;
//    private final CommentService commentService; 서비스에서 묶어서 같이보내는것이 좋은건지 아니면 프론트에서 따로 조회하는것이 좋은지 모륵세
//    private final HeartService heartService;


    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public int addPost(int categoryId, int subCategoryId, String userId, String title, String contents, String source) {
        Post post = Post.builder()
                .categoryId(categoryId)
                .subCategoryId(subCategoryId)
                .userId(userId)
                .title(title)
                .contents(contents)
                .source(source)
                .build();
        postRepository.save(post);
        return post.getId();
    }

    public PostView getPost(int id) {
        Post post = Optional.ofNullable(postRepository.findById(id)).orElseThrow(() -> new NotFoundException("게시글이 존재하지 않습니다"));
        return PostView.from(post);
    }

    public List<PostListView> getPostList(int subCategoryId, Timestamp postCursor, int page, Integer size) {
        if (postCursor == null) {
            postCursor = currentTime;
        }
        Pageable pageable = MakePageAble.makePageAble(page, size);
        return postRepository.findBySubCategoryIdAndCreatedAtLessThanEqualOrderByCreatedAtDesc(subCategoryId, postCursor, pageable)
                .stream()
                .map(PostListView::from)
                .collect(Collectors.toList());
    }

    public List<PostListView> findPostsByUserId(String userId) {
        List<PostListView> posts = postRepository.findByUserId(userId)
                .stream()
                .map(PostListView::from)
                .collect(Collectors.toList());
        return posts;
    }

    public void deletePostById(int id, String userId) {
        Post post = Optional.ofNullable(postRepository.findById(id)).orElseThrow(() -> new NotFoundException("삭제할 아이디가 존재하지 않습니다"));
        if (userId.equals(post.getUserId())) {
            postRepository.deletePostById(id);
        }
    }

    public int updatePost(int id, int subCategoryId, String userId, String title, String contents, String source, Date createAt) {
        Post post = postRepository.findById(id);
        if (!userId.equals(post.getUserId())) {
            throw new NotFoundException("아이디가 일치하지 않습니다");
        }
        post.setSubCategoryId(subCategoryId);
        post.setTitle(title);
        post.setContents(contents);
        post.setSource(source);
        post.setUpdatedAt(createAt);
        postRepository.save(post); //새로들어온걸 from으로 넣어서 save로 하면댄다 이럴때 이해 실패
        return post.getId();

    }

    public List<PostListView> findPostsByTitle(String keyword, Timestamp searchCursor, int page, Integer size) {
        if (searchCursor == null) {
            searchCursor = currentTime;
        }
        Pageable pageable = MakePageAble.makePageAble(size, page);
        return postRepository.findByTitleContainsAndCreatedAtLessThanEqualOrderByCreatedAtDesc(keyword, searchCursor, pageable)
                .stream()
                .map(PostListView::from)
                .collect(Collectors.toList());
    }
}
