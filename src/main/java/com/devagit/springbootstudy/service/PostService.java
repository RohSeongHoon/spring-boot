package com.devagit.springbootstudy.service;


import com.devagit.springbootstudy.domain.Heart;
import com.devagit.springbootstudy.domain.Post;
import com.devagit.springbootstudy.exceptionHandler.badrequest.PostBadRequestException;
import com.devagit.springbootstudy.exceptionHandler.notfound.PostNotFoundException;
import com.devagit.springbootstudy.repository.heart.HeartRepository;
import com.devagit.springbootstudy.repository.post.PostRepository;
import com.devagit.springbootstudy.util.Page;
import com.devagit.springbootstudy.view.post.PostListView;
import com.devagit.springbootstudy.view.post.PostView;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PostService {
    private final PostRepository postRepository;
    private final HeartRepository heartRepository;
//    private final CommentService commentService; 서비스에서 묶어서 같이보내는것이 좋은건지 아니면 프론트에서 따로 조회하는것이 좋은지 모륵세


    public PostService(PostRepository postRepository, HeartRepository heartRepository) {
        this.postRepository = postRepository;

        this.heartRepository = heartRepository;
    }

    @Transactional
    public long addPost(int subCategoryId, String userId, String title, String contents, @Nullable String videoSource,@Nullable String imgSource) {
        Post post = Post.builder()
                .subCategoryId(subCategoryId)
                .userId(userId)
                .title(title)
                .contents(contents)
                .videoSource(videoSource)
                .imgSource(imgSource)
                .build();
        postRepository.save(post);
        return post.getId();
    }

    public PostView getPost(long id) {
        Post post = Optional.ofNullable(postRepository.findById(id)).orElseThrow(() -> new PostNotFoundException());
        return PostView.from(post);
    }

    public Page<PostListView> getPostList(int subCategoryId, @Nullable LocalDateTime postCursor, int page, @Nullable Integer size) {
        if (postCursor == null) { //currentTime은 무조건 메소드내부에서 생성
            postCursor = LocalDateTime.now();
        }
        Pageable pageable = PageRequest.of(page, size);
        postCursor.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        List<PostListView> postListViews = postRepository.findBySubCategoryIdAndCreatedAtLessThanEqualOrderByCreatedAtDesc(subCategoryId, postCursor, pageable)
                .stream()
                .map(PostListView::from)
                .collect(Collectors.toList());
        return Page.convert(postListViews, PostListView::getCreatedAt, postListViews.size(), null);
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
        Post post = Optional.ofNullable(postRepository.findById(id)).orElseThrow(PostNotFoundException::new);
        if (userId.equals(post.getUserId())) {
            postRepository.deletePostById(id);
        }
    }

    @Transactional
    public long updatePost(long id, int subCategoryId, String userId, String title, String contents, @Nullable String videoSource,@Nullable String imgSource) {
        Post post = postRepository.findById(id);
        if (!userId.equals(post.getUserId())) {
            throw new PostBadRequestException("아이디가 일치하지 않습니다");
        }
        LocalDateTime updatedAt = LocalDateTime.now();
        post.setSubCategoryId(subCategoryId);
        post.setTitle(title);
        post.setContents(contents);
        post.setVideoSource(videoSource);
        post.setImgSource(imgSource);
        post.setUpdatedAt(updatedAt);
        postRepository.save(post); //새로들어온걸 from으로 넣어서 save로 하면댄다 이럴때 이해 실패
        return post.getId();

    }

    public List<PostListView> findPostsByTitle(String keyword, LocalDateTime searchCursor, int page, Integer size) {
        if (searchCursor == null) {
            searchCursor = LocalDateTime.now();
        }
        return postRepository.findByTitleContainsAndCreatedAtLessThanEqualOrderByCreatedAtDesc(keyword, searchCursor, PageRequest.of(page, size))
                .stream()
                .map(PostListView::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public void plusHeartCnt(long postId) {
        Post post = postRepository.findById(postId);
        post.setHeartCnt(post.getHeartCnt() + 1);
        postRepository.save(post);
    }

    @Transactional
    public void minusHeartCnt(long postId) {
        Post post = postRepository.findById(postId);
        post.setHeartCnt(post.getHeartCnt() - 1);
        postRepository.save(post);
    }

    public Page<PostListView> getLikedPost(String userId) {
        List<Long> likedPostIds = heartRepository.findByUserId(userId).stream().map(Heart::getPostId).collect(Collectors.toList());
        List<PostListView> posts = postRepository.findByIdIn(likedPostIds).stream().map(PostListView::from).collect(Collectors.toList());
        int limit = 3;
        return  Page.convert(posts,PostListView::getCreatedAt,limit,null);
    }
}
