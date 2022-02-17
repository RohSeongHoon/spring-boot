package com.devagit.springbootstudy.service;

import com.devagit.springbootstudy.domain.post.Post;
import com.devagit.springbootstudy.exceptionHandler.PostNotFoundException;
import com.devagit.springbootstudy.exceptionHandler.UserNotFoundException;
import com.devagit.springbootstudy.repository.post.PostRepository;
import com.devagit.springbootstudy.view.post.PostListView;
import com.devagit.springbootstudy.view.post.PostView;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.devagit.springbootstudy.exceptionHandler.ErrorCode.POST_NOT_FOUND;
import static com.devagit.springbootstudy.exceptionHandler.ErrorCode.USER_ID_NOT_THE_SAME;


@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public int addPost(int categoryId, int subCategoryId, String userId, String title, String contents, String source) {
        Post post = Post.builder()      //null값이 들어갈때 명확하게 표현을 해주는게 좋음
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
        Post post = Optional.ofNullable(postRepository.findById(id)).orElseThrow(() -> new PostNotFoundException(POST_NOT_FOUND));
        return PostView.from(post);
        //예외처리 꼭하기 명심
    }

    public List<PostListView> getPostList(int subCategoryId) {
        return postRepository.findBySubCategoryId(subCategoryId)
                .stream()
                .filter(post -> post.getSubCategoryId() == subCategoryId)
                .sorted(Comparator.comparing(Post::getCreateAt))
                .map(PostListView::from)
                .limit(20)          //db에서
                .collect(Collectors.toList());
    } //db에서 페이지 나누는것 찾아보기

    public List<PostListView> findPostsByUserId(String userId) {
        List<PostListView> posts = postRepository.findByUserId(userId)
                .stream()
                .sorted(Comparator.comparing(Post::getCreateAt))
                .map(PostListView::from)
                .collect(Collectors.toList());
        return posts; //db에서 정렬해서 가지고오기
    }

    public void deletePostById(int id, String userId) {
        Post post = Optional.ofNullable(postRepository.findById(id)).orElseThrow(() -> new PostNotFoundException(POST_NOT_FOUND));
        if (userId.equals(post.getUserId())) {
            postRepository.deletePostById(id);
        }
    }

    public int updatePost(int id, int subCategoryId, String userId, String title, String contents, String source, Date createAt) {
        Post post = postRepository.findById(id);
        if (!userId.equals(post.getUserId())) {
            throw new UserNotFoundException(USER_ID_NOT_THE_SAME);
        }
        post.setSubCategoryId(subCategoryId);
        post.setTitle(title);
        post.setContents(contents);
        post.setSource(source);
        post.setUpdateAt(createAt);
        postRepository.save(post); //새로들어온걸 from으로 넣어서 save로 하면댄다 이럴때 이해 실패
        return post.getId();

    }
}
