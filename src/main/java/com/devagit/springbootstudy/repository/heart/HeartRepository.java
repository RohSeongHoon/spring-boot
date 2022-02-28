package com.devagit.springbootstudy.repository.heart;

import com.devagit.springbootstudy.domain.Heart;

public interface HeartRepository {


    Heart findByPostIdAndUserId(int postId, String userId);

    void deleteByPostIdAndUserId(int postId, String userId);

    void save(Heart heart);

    int countByPostId(int postId);
}
