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
    private String videoSource;
    private String imgSource;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public PostView(long id, int subCategoryId, String userId, String title, String contents, String videoSource,String imgSource, LocalDateTime createdAt,LocalDateTime updatedAt) {
        this.id = id;
        this.subCategoryId = subCategoryId;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
        this.videoSource = videoSource;
        this.imgSource = imgSource;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;

    }
    public static PostView from(Post post) {
        return PostView.builder()
                .id(post.getId())
                .subCategoryId(post.getSubCategoryId())
                .userId(post.getUserId())
                .title(post.getTitle())
                .contents(post.getContents())
                .videoSource(post.getVideoSource())
                .imgSource(post.getImgSource())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }
}
