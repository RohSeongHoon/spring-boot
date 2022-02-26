package com.devagit.springbootstudy.request.heart;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddOrDeleteHeartRequest {
    private int postId;
   private String userId;

    public AddOrDeleteHeartRequest(String userId) {
        this.userId = userId;
    }
}

