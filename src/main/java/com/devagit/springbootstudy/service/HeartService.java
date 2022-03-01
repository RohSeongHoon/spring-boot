package com.devagit.springbootstudy.service;

import com.devagit.springbootstudy.domain.Heart;
import com.devagit.springbootstudy.exceptionHandler.notfound.HeartNotFoundException;
import com.devagit.springbootstudy.repository.heart.HeartRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

//count대신 컬럼을 생성
@Service
public class HeartService {
    private HeartRepository heartRepository;
    private PostService postService;

    public HeartService(HeartRepository heartRepository, PostService postService) {
        this.heartRepository = heartRepository;
        this.postService = postService; //service끼리? 아니면 repository?
    }

    //두개로 나눠야함
    @Transactional
    public boolean addHeart(int postId, String userId) {
        heartRepository.save(new Heart(postId, userId));
        postService.setHeartCnt(postId, 1);
        return true;
    }

    @Transactional
    public boolean deleteHeart(int postId, String userId) {
        Optional.ofNullable(heartRepository.findByPostIdAndUserId(postId, userId)).orElseThrow(() -> new HeartNotFoundException("못찾음"));
        heartRepository.deleteByPostIdAndUserId(postId, userId);
        postService.setHeartCnt(postId, -1);
        return false;
    }

    public Boolean findHeartByUserId(int postId, String userId) {
        Heart heart = heartRepository.findByPostIdAndUserId(postId, userId);
        if (heart == null) {
            return true;
        }
        return false;
    }



}
