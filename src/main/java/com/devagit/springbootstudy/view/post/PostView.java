package com.devagit.springbootstudy.view.post;

import com.devagit.springbootstudy.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
@NoArgsConstructor
public class PostView {
    private long id;
    private int subCategoryId;
    private String userId;
    private String title;
    private String contents;
    private String source;
    private LocalDateTime createdAt;

    @Builder
    public PostView(long id, int subCategoryId, String userId, String title, String contents, String source, LocalDateTime createdAt) {
        this.id = id;
        this.subCategoryId = subCategoryId;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
        this.source = source;
        this.createdAt = createdAt;

    }
    public static PostView from(Post post) {
        return PostView.builder()
                .id(post.getId())
                .subCategoryId(post.getSubCategoryId())
                .userId(post.getUserId())
                .title(post.getTitle())
                .contents(post.getContents())
                .source(post.getSource())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
