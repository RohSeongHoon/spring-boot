package com.devagit.springbootstudy.request.post;

import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
public class WritePostRequest {
    private int categoryId;
    private int subCategoryId;
    private String userId;
    private String title;
    private String contents;
    private String source;


    public WritePostRequest(int categoryId, int subCategoryId, String userId, String title, String contents, String source) {
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
        this.source = source;
    }
}
