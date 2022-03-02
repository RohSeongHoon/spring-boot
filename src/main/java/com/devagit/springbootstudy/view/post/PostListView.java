package com.devagit.springbootstudy.view.post;

import com.devagit.springbootstudy.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@NoArgsConstructor
public class PostListView {
    private long id;
    private int subCategoryId;
    private String userId;
    private String title;
    private LocalDateTime createdAt;

    @Builder
    public PostListView(long id, int subCategoryId, String userId, String title, LocalDateTime createdAt) {
        this.id = id;
        this.subCategoryId = subCategoryId;
        this.userId = userId;
        this.title = title;
        this.createdAt=createdAt;
    }

    public static PostListView from(Post post){
        return PostListView.builder()
                .id(post.getId())
                .subCategoryId(post.getSubCategoryId())
                .userId(post.getUserId())
                .title(post.getTitle())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
