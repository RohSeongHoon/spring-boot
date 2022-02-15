package com.devagit.springbootstudy.view.post;

import com.devagit.springbootstudy.domain.post.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class PostView {
    private int id;
    private int subCategoryId;
    private String userId;
    private String title;
    private String contents;
    private String source;
    private String writeDate;

    @Builder
    public PostView(int id, int subCategoryId, String userId, String title, String contents, String source, String writeDate) {
        this.id = id;
        this.subCategoryId = subCategoryId;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
        this.source = source;
        this.writeDate = writeDate;
    }
    public static PostView from(Post post) {
        return PostView.builder()
                .id(post.getId())
                .subCategoryId(post.getSubCategoryId())
                .userId(post.getUserId())
                .title(post.getTitle())
                .contents(post.getContents())
                .source(post.getSource())
                .writeDate(post.getWriteDate())
                .build();
    }
}
