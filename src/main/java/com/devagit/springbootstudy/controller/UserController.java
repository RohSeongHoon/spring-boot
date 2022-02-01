package com.devagit.springbootstudy.controller;


import com.devagit.springbootstudy.domain.user.*;
import com.devagit.springbootstudy.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //로그인 기능
    //아이디 중복확인
    //post로 아이디와 비번을 보냄
    //db에서 기본키인 아이디를 검색
    //아이디가 있으면 비밀번호 비교
    //비밀번호가 같다면 로그인 성공
    //비밀번호가 틀리다면 로그인 실패
    //아이디가 없다면 예외처리


    //회워가입
    //비밀번호에 특수문자 있어야함

    @PostMapping("/api/v1/users/login")
    public String login(@RequestBody LoginRequest req) {
        return userService.login(req.getUserId(), req.getPassword());
    }

    //회원가입 만들기
    @PostMapping("/api/v1/users")
    public UserView signUp(@RequestBody UserRequest req) {
        return userService.signUp(req);
    }

    @PostMapping("api/v1/users/findPassword")
    public String findPasswordByUserId(@RequestBody FindPasswordByUserIdRequest req){
        return userService.findPasswordByUserId(req.getUserId(),req.getUsername(),req.getPhoneNumber());

    }

    @GetMapping("/api/v1/users")
    public List<UserView> findAllUsers(@RequestParam(required = false) String username) {
        return userService.findAllUsers();
    }

    @GetMapping(value = "/api/v1/users", params = "username")
    public UserView findUserByUserName(@RequestParam(required = false) String username) {
        return userService.findByUsername(username);
    }
}
