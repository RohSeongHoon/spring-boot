package com.devagit.springbootstudy.repository.heart;

import com.devagit.springbootstudy.domain.Heart;

import java.util.List;
import java.util.Optional;

public interface HeartRepository {


    Optional<Heart> findByPostIdAndUserId(long postId, String userId);

    void deleteByPostIdAndUserId(long postId, String userId);

    void save(Heart heart);

    void delete(Heart heart);

    List<Heart> findByUserId(String userId);

}
