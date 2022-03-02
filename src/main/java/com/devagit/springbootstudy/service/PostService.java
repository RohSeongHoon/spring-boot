package com.devagit.springbootstudy.service;


import com.devagit.springbootstudy.domain.Post;
import com.devagit.springbootstudy.exceptionHandler.badrequest.PostBadRequestException;
import com.devagit.springbootstudy.exceptionHandler.notfound.NotFoundException;
import com.devagit.springbootstudy.exceptionHandler.notfound.PostNotFoundException;
import com.devagit.springbootstudy.repository.post.PostRepository;
import com.devagit.springbootstudy.util.MakePageAble;
import com.devagit.springbootstudy.view.post.PostListView;
import com.devagit.springbootstudy.view.post.PostView;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Transactional
    public long addPost(int categoryId, int subCategoryId, String userId, String title, String contents, String source) {
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

    public PostView getPost(long id) {
        Post post = Optional.ofNullable(postRepository.findById(id)).orElseThrow(() -> new PostNotFoundException());
        return PostView.from(post);
    }

    public List<PostListView> getPostList(int subCategoryId, @Nullable LocalDateTime postCursor, int page, @Nullable Integer size) {
        if (postCursor == null) { //currentTime은 무조건 메소드내부에서 생성
            postCursor = LocalDateTime.parse(currentTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }
        postCursor.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
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

    @Transactional
    public void deletePostById(long id, String userId) {
        Post post = Optional.ofNullable(postRepository.findById(id)).orElseThrow(() -> new PostNotFoundException());
        if (userId.equals(post.getUserId())) {
            postRepository.deletePostById(id);
        }
    }

    @Transactional
    public long updatePost(long id, int subCategoryId, String userId, String title, String contents, @Nullable String source, LocalDateTime createAt) {
        Post post = postRepository.findById(id);
        if (!userId.equals(post.getUserId())) {
            throw new PostBadRequestException("아이디가 일치하지 않습니다");
        }
        post.setSubCategoryId(subCategoryId);
        post.setTitle(title);
        post.setContents(contents);
        post.setSource(source);
        post.setUpdatedAt(createAt);
        postRepository.save(post); //새로들어온걸 from으로 넣어서 save로 하면댄다 이럴때 이해 실패
        return post.getId();

    }

    public List<PostListView> findPostsByTitle(String keyword, LocalDateTime searchCursor, int page, Integer size) {
        if (searchCursor == null) {
            searchCursor = currentTime;
        }
        Pageable pageable = MakePageAble.makePageAble(size, page);
        return postRepository.findByTitleContainsAndCreatedAtLessThanEqualOrderByCreatedAtDesc(keyword, searchCursor, pageable)
                .stream()
                .map(PostListView::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public void plusHeartCnt(long postId) {
        Post post = postRepository.findById(postId); // optional추가 이것도 + - 나누기
        post.setHeartCnt(post.getHeartCnt() + 1);
        postRepository.save(post);
    }

    @Transactional
    public void minusHeartCnt(long postId) {
        Post post = postRepository.findById(postId); // optional추가 이것도 + - 나누기
        post.setHeartCnt(post.getHeartCnt() - 1);
        postRepository.save(post);
    }
}
