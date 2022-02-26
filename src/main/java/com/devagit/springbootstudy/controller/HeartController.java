package com.devagit.springbootstudy.controller;

import com.devagit.springbootstudy.request.heart.AddOrDeleteHeartRequest;
import com.devagit.springbootstudy.service.HeartService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class HeartController {
    private HeartService heartService;

    public HeartController(HeartService likeService) {
        this.heartService = likeService;
    }

    @PostMapping("api/v1/{postId}/heart")
    public boolean addOrDeleteHeart(@PathVariable("postId") int postId, @RequestBody AddOrDeleteHeartRequest req) {
        return heartService.addOrDeleteHeart(postId, req.getUserId());
    }

    @GetMapping("api/v1/{postId}/heart")
    public int getHeartCount(@PathVariable int postId) {
        return heartService.getHeartCount(postId);
    }
}
