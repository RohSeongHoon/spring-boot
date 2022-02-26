package com.devagit.springbootstudy.service;

import com.devagit.springbootstudy.domain.heart.Heart;
import com.devagit.springbootstudy.repository.heart.HeartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeartService {
    private HeartRepository heartRepository;

    public HeartService(HeartRepository heartRepository) {
        this.heartRepository = heartRepository;
    }

    public boolean addOrDeleteHeart(int postId,String userId) {
        if (!findHeartByUserId(postId,userId)){
            deleteHeart(postId,userId);
            return false;
        }
        Heart heart = new Heart(postId,userId);
          heartRepository.addHeart(heart);
        return true;
    }

    public Boolean findHeartByUserId(int postId,String userId) {
       Heart heart = heartRepository.findByPostIdAndUserId(postId,userId);
       if (heart == null){
          return true;
       }
       return false;
    }
    public void deleteHeart(int postId,String userId){
        heartRepository.deleteByPostIdAndUserId(postId,userId);
    }
}
