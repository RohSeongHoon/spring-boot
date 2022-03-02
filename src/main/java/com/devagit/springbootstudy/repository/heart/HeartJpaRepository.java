package com.devagit.springbootstudy.repository.heart;

import com.devagit.springbootstudy.domain.Heart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface HeartJpaRepository extends JpaRepository<Heart, Long> {

    Optional<Heart> findByPostIdAndUserId(long postId, String userId);

    void deleteByPostIdAndUserId(long postId, String userId);

    long countByPostId(long postId);
}
