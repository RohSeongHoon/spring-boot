package com.devagit.springbootstudy.service;

import com.devagit.springbootstudy.domain.Heart;
import com.devagit.springbootstudy.repository.heart.HeartRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//count대신 컬럼을 생성
@Service
public class HeartService {
    private HeartRepository heartRepository;

    public HeartService(HeartRepository heartRepository) {
        this.heartRepository = heartRepository;
    }

    //두개로 나눠야함
    public boolean addOrDeleteHeart(int postId, String userId) {
        if (!findHeartByUserId(postId, userId)) {
            deleteHeart(postId, userId);
            return false;
        }
        Heart heart = new Heart(postId, userId);
        heartRepository.save(heart);
        return true;
    }

    public Boolean findHeartByUserId(int postId, String userId) {
        Heart heart = heartRepository.findByPostIdAndUserId(postId, userId);
        if (heart == null) {
            return true;
        }
        return false;
    }

    @Transactional
    public void deleteHeart(int postId, String userId) {
        heartRepository.deleteByPostIdAndUserId(postId, userId);
    }

    @Transactional
    public int getHeartCount(int postId) {
        return heartRepository.countByPostId(postId);
    }
}
