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
    private PostService postService; //원래는 event로 한다고함

    public HeartService(HeartRepository heartRepository, PostService postService) {
        this.heartRepository = heartRepository;
        this.postService = postService; //service끼리? 아니면 repository?
    }

    //두개로 나눠야함
    @Transactional
    public boolean addHeart(long postId, String userId) {
        heartRepository.save(new Heart(postId, userId));
        postService.setHeartCnt(postId, 1);
        return true;
    }

    @Transactional
    public boolean deleteHeart(long postId, String userId) {
        Heart heart = Optional.ofNullable(heartRepository.findByPostIdAndUserId(postId, userId)).orElseThrow(HeartNotFoundException::new); // optional로받아오기 jpa
        //heartRepository.deleteByPostIdAndUserId(postId, userId);
        heartRepository.delete(heart);
        postService.setHeartCnt(postId, -1);
        return false;
    }
  //
    public Boolean findHeartByUserId(long postId, String userId) {
        Heart heart = heartRepository.findByPostIdAndUserId(postId, userId);
        if (heart == null) {
            return true;
        }
        return false;
    }


}
