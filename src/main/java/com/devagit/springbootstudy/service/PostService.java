package com.devagit.springbootstudy.service;


import com.devagit.springbootstudy.domain.post.Post;
import com.devagit.springbootstudy.exceptionHandler.NotFoundException;
import com.devagit.springbootstudy.repository.comment.CommentRepository;
import com.devagit.springbootstudy.repository.post.PostRepository;
import com.devagit.springbootstudy.util.MakePageAble;
import com.devagit.springbootstudy.view.post.PostListView;
import com.devagit.springbootstudy.view.post.PostView;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;



    public PostService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
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
        //예외처리 꼭하기 명심
    }

    public List<PostListView> getPostList(int subCategoryId,Date postCursor, int page, Integer size) {
        Pageable pageable = MakePageAble.makePageAble(postCursor,size,page);
        return postRepository.findBySubCategoryIdAndCreatedAtLessThanEqualOrderByCreatedAtDesc(subCategoryId,postCursor, pageable)
                .stream()
                .map(PostListView::from)
                .collect(Collectors.toList());
    } //db에서 페이지 나누는것 찾아보기

    public List<PostListView> findPostsByUserId(String userId) {
        List<PostListView> posts = postRepository.findByUserId(userId)
                .stream()
                .map(PostListView::from)
                .collect(Collectors.toList());
        return posts; //db에서 정렬해서 가지고오기
    }

    public void deletePostById(int id, String userId) {
        Post post = Optional.ofNullable(postRepository.findById(id)).orElseThrow(() -> new NotFoundException("삭제할 아이디가 존재하지 않습니다"));
        if (userId.equals(post.getUserId())) {
            postRepository.deletePostById(id);
            commentRepository.deleteCommentsByPostId(id);
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

    public List<PostListView> findPostsByTitle(String keyword,Date searchCursor,int page,Integer size) {
               Pageable pageable  = MakePageAble.makePageAble(searchCursor,size,page);
        return postRepository.findByTitleContainsAndCreatedAtLessThanEqualOrderByCreatedAtDesc(keyword, searchCursor,pageable)
                .stream()
                .map(PostListView::from)
                .collect(Collectors.toList());
    }
}
