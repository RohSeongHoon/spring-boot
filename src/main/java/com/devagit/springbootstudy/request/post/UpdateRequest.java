package com.devagit.springbootstudy.request.post;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
public class UpdateRequest {
    private int id;
    private int subCategoryId;
    private String userId;
    private String title;
    private String contents;
    private String source;
    private LocalDateTime createdAt;

    public UpdateRequest(int id, int subCategoryId, String userId, String title, String contents, String source, LocalDateTime createdAt) {
        this.id = id;
        this.subCategoryId = subCategoryId;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
        this.source = source;
        this.createdAt = createdAt;
    }
}
