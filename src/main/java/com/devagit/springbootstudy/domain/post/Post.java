package com.devagit.springbootstudy.domain.post;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "INT", nullable = false, unique = true)
    private int id;
    @Column(columnDefinition = "INT", nullable = false)
    private int categoryId;
    @Column(columnDefinition = "INT", nullable = false)
    private int subCategoryId;
    @Column(columnDefinition = "VARCHAR(32)", nullable = false)
    private String userId;
    @Column(columnDefinition = "VARCHAR(128)", nullable = false)
    private String title;
    @Column(columnDefinition = "VARCHAR(1024)", nullable = false)
    private String contents;
    //무조건 있어야하는 것은 DB에서 넣는게 맞다
    //넣는 방법은 더 생각
    //createdAt 을 관용 , 업데이트: updatedAt, deletedAt 관용암
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP",nullable = true)
    private String writeDate;
    @Column(columnDefinition = "VARCHAR(64)")
    private String source;

    @Builder
    public Post(int categoryId, int subCategoryId, String userId, String title, String contents, String source,String writeDate) {
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
        this.source = source;
        this.writeDate = writeDate;
    }
}

