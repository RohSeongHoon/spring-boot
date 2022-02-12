package com.devagit.springbootstudy.view;

import com.devagit.springbootstudy.domain.posts.Post;
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
        return new PostView(post.getId(), post.getSubCategoryId(), post.getUserId(), post.getTitle(), post.getContents(), post.getSource(), post.getWriteDate());
    }
}
