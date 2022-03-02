package com.devagit.springbootstudy.controller;

import com.devagit.springbootstudy.request.heart.AddOrDeleteHeartRequest;
import com.devagit.springbootstudy.service.HeartService;
import org.springframework.web.bind.annotation.*;

@RestController
public class HeartController {
    private HeartService heartService;

    public HeartController(HeartService likeService) {
        this.heartService = likeService;
    }

    @PostMapping("api/v1/{postId}/heart")
    public boolean addHeart(@PathVariable("postId") long postId, @RequestBody AddOrDeleteHeartRequest req) {
        return heartService.addHeart(postId, req.getUserId());
    }
    @DeleteMapping("api/v1/{postId}/heart")
        public boolean deleteHeart(@PathVariable("postId") long postId,@RequestBody AddOrDeleteHeartRequest req){
        return heartService.deleteHeart(postId,req.getUserId());
        }
}
