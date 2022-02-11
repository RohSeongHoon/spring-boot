package com.devagit.springbootstudy.request.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class WritePostRequest {
    private int categoryId;
    private int subCategoryId;
    private String userId;
    private String title;
    private String contents;
    private String source;
}
