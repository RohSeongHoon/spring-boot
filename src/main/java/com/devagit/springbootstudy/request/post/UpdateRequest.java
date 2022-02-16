package com.devagit.springbootstudy.request.post;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;


@NoArgsConstructor
@Getter
public class UpdateRequest {
    private int id;
    private int subCategoryId;
    private String userId;
    private String title;
    private String contents;
    private String source;
    private Date createAt;

    public UpdateRequest(int id, int subCategoryId, String userId, String title, String contents, String source, Date createAt) {
        this.id = id;
        this.subCategoryId = subCategoryId;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
        this.source = source;
        this.createAt = createAt;
    }
}
