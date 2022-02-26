package com.devagit.springbootstudy.repository.heart;

import com.devagit.springbootstudy.domain.heart.Heart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HeartJpaRepository extends JpaRepository<Heart, Integer> {

    Heart findByPostIdAndUserId(int postId, String userId);

    void deleteByPostIdAndUserId(int postId, String userId);

    int countByPostId(int postId);
}
