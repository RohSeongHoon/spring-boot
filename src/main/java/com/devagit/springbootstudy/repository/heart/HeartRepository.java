package com.devagit.springbootstudy.repository.heart;

import com.devagit.springbootstudy.domain.Heart;

public interface HeartRepository {


    Heart findByPostIdAndUserId(long postId, String userId);

    void deleteByPostIdAndUserId(long postId, String userId);

    void save(Heart heart);

    int countByPostId(long postId);

    void delete(Heart heart);
}
