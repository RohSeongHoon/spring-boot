package com.devagit.springbootstudy.request.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
public class UpdateRequest {
    private long id;
    private  int subCategoryId;
    private String userId;
    private String title;
    private String contents;
    private String videoSource;
    private String imgSource;

    public UpdateRequest(long id, int subCategoryId, String userId, String title, String contents, @Nullable String videoSource,@Nullable String imgSource) {
        this.id = id;
        this.subCategoryId = subCategoryId;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
        this.videoSource = videoSource;
        this.imgSource = imgSource;
    }
}
