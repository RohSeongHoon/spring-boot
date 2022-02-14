package com.devagit.springbootstudy.view.post;

import com.devagit.springbootstudy.domain.posts.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostListView {
    private int id;
    private int subCategoryId;
    private String userId;
    private String title;
    private String writeDate;

    @Builder
    public PostListView(int id, int subCategoryId, String userId, String title, String writeDate) {
        this.id = id;
        this.subCategoryId = subCategoryId;
        this.userId = userId;
        this.title = title;
        this.writeDate = writeDate;
    }

    public static PostListView postList(Post post){
        return PostListView.builder()
                .id(post.getId())
                .subCategoryId(post.getSubCategoryId())
                .userId(post.getUserId())
                .title(post.getTitle())
                .writeDate(post.getWriteDate())
                .build();
    }
}
