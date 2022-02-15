package com.devagit.springbootstudy.service;

import com.devagit.springbootstudy.domain.post.Post;
import com.devagit.springbootstudy.exceptionHandler.PostNotFoundException;
import com.devagit.springbootstudy.repository.post.PostRepository;
import com.devagit.springbootstudy.view.post.PostListView;
import com.devagit.springbootstudy.view.post.PostView;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.devagit.springbootstudy.exceptionHandler.ErrorCode.POST_NOT_FOUND;


@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //controller에서 메소드명 동일하게 작성
    public void addPost(int categoryId, int subCategoryId, String userId, String title, String contents, String source) {
        long time = System.currentTimeMillis();
        //datetype으로
        SimpleDateFormat simpl = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");
        String writeDate = simpl.format(time);
        Post post = Post.builder()      //null값이 들어갈때 명확하게 표현을 해주는게 좋음
                .categoryId(categoryId)
                .subCategoryId(subCategoryId)
                .userId(userId)
                .title(title)
                .contents(contents)
                .source(source)
                .writeDate(writeDate)
                .build();
        postRepository.save(post);
        //저장하고 아이디 값정도는 보내는게 좋음
    }

    public PostView getPost(int id) {
        Post post = postRepository.findById(id);
        return PostView.from(post);
        //예외처리 꼭하기 명심
    }

    public List<PostListView> getPostList(int subCategoryId) {
        return postRepository.findAll() //subCategoryId로 조회 findAll을 사용하는것이 아니다. (limit를 사용하기),(인덱스를 더공부)
                .stream()
                .filter(post -> post.getSubCategoryId() == subCategoryId)
                .sorted(Comparator.comparing(Post::getWriteDate)) //여기서 하지말고 db에서 꺼낼때 orderBy사용
                .map(PostListView::from)
                .collect(Collectors.toList());
    }

    public List<PostListView> findPostsByUserId(String userId) {
        List<PostListView> posts = postRepository.findByUserId(userId)
                .stream()
                .sorted(Comparator.comparing(Post::getWriteDate))
                .map(PostListView::from)
                .collect(Collectors.toList());
        if (posts.isEmpty()) {
            throw new PostNotFoundException(POST_NOT_FOUND);
        } // 리스트로 보낼때는 예외처리를 하지 않고 빈객체를 보낸다
        return posts;
    }

    public void deletePostById(int id) {
        postRepository.deletePostById(id);
    }

    public void updatePost(int id) {
        Post post = postRepository.findById(id);
        postRepository.save(post); //새로들어온걸 from으로 넣어서 save로 하면댄다 이럴때
    }
}
