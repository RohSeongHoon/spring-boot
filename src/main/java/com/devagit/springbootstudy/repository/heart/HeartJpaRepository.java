package com.devagit.springbootstudy.repository.heart;

import com.devagit.springbootstudy.domain.Heart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HeartJpaRepository extends JpaRepository<Heart, Integer> {

    Heart findByPostIdAndUserId(long postId, String userId);

    void deleteByPostIdAndUserId(long postId, String userId);

    int countByPostId(long postId);
}
