package com.devagit.springbootstudy.request.post;

import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
public class DeletePostById {
    private int id;
    private String userId;


    public DeletePostById(int id, String userId) {
        this.id = id;
        this.userId = userId;
    }
}
//게시글 주인만 지울 수 있게 아이디도 같이 받아와야한다