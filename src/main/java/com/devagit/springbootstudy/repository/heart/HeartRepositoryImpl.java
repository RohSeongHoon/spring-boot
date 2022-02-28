package com.devagit.springbootstudy.repository.heart;

import com.devagit.springbootstudy.domain.Heart;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class HeartRepositoryImpl implements HeartRepository {
    private HeartJpaRepository heartJpaRepository;

    public HeartRepositoryImpl(HeartJpaRepository heartJpaRepository) {
        this.heartJpaRepository = heartJpaRepository;
    }

    @Override
    public void save(Heart heart) {
        heartJpaRepository.save(heart);
    }

    @Override
    public int countByPostId(int postId) {
        return heartJpaRepository.countByPostId(postId);
    }

    @Override
    public Heart findByPostIdAndUserId(int postId, String userId) {
        return heartJpaRepository.findByPostIdAndUserId(postId, userId);
    }

    @Override
    @Transactional
    public void deleteByPostIdAndUserId(int postId, String userId) {
        heartJpaRepository.deleteByPostIdAndUserId(postId, userId);
    }


}
