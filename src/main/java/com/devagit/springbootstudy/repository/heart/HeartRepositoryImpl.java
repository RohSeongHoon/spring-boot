package com.devagit.springbootstudy.repository.heart;

import com.devagit.springbootstudy.domain.Heart;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
    public void delete(Heart heart) {
        heartJpaRepository.delete(heart);
    }

    @Override
    public List<Heart> findByUserId(String userId) {
        return heartJpaRepository.findByUserId(userId);
    }

    @Override
    public Optional<Heart> findByPostIdAndUserId(long postId, String userId) {
        return heartJpaRepository.findByPostIdAndUserId(postId, userId);
    }

    @Override
    @Transactional
    public void deleteByPostIdAndUserId(long postId, String userId) {
        heartJpaRepository.deleteByPostIdAndUserId(postId, userId);
    }


}
