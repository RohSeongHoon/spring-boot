package com.devagit.springbootstudy.view.post;

import com.devagit.springbootstudy.domain.post.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class PostListView {
    private int id;
    private int subCategoryId;
    private String userId;
    private String title;
    private Date createAt;

    @Builder
    public PostListView(int id, int subCategoryId, String userId, String title, Date createAt) {
        this.id = id;
        this.subCategoryId = subCategoryId;
        this.userId = userId;
        this.title = title;
        this.createAt=createAt;
    }

    public static PostListView from(Post post){
        return PostListView.builder()
                .id(post.getId())
                .subCategoryId(post.getSubCategoryId())
                .userId(post.getUserId())
                .title(post.getTitle())
                .createAt(post.getCreateAt())
                .build();
    }
}
