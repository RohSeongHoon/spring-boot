package com.devagit.springbootstudy.repository.heart;

import com.devagit.springbootstudy.domain.Heart;

import java.util.Optional;

public interface HeartRepository {


    Optional<Heart> findByPostIdAndUserId(long postId, String userId);

    void deleteByPostIdAndUserId(long postId, String userId);

    void save(Heart heart);

    long countByPostId(long postId);

    void delete(Heart heart);
}
