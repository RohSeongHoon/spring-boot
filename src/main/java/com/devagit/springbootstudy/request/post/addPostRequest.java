package com.devagit.springbootstudy.request.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;


@NoArgsConstructor
@Getter
public class addPostRequest {
    private int subCategoryId;
    private String userId;
    private String title;
    private String contents;
    private String videoSource;
    private String imgSource;


    public addPostRequest(int subCategoryId, String userId, String title, String contents, @Nullable String videoSource,@Nullable String imgSource) {
        this.subCategoryId = subCategoryId;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
        this.videoSource = videoSource;
        this.imgSource = imgSource;
    }
}
