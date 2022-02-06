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


    //회원 가입  ===================================
    @PostMapping("/api/v1/users")
    public UserView signUp(@RequestBody UserRequest req) {
        return userService.signUp(req.getUserId(), req.getUsername(), req.getPassword(), req.getPhoneNumber());
    }

    //로그인 ===================================
    @PostMapping("/api/v1/users/login")
    public String login(@RequestBody LoginRequest req) {
        return userService.login(req.getUserId(), req.getPassword());
    }

    //회원 정보 조회 ===================================
    @PostMapping("api/v1/users/findPassword")
    public String findPasswordByUserId(@RequestBody FindPasswordByUserIdRequest req) {
        return userService.findPasswordByUserId(req.getUserId(), req.getUsername(), req.getPhoneNumber());
    }

    @PostMapping("api/v1/users/findId")
    public String findIdByUserPhoneNumber(@RequestBody FindIdByUserPhoneNumRequest req) {
        return userService.findIdByPhoneNumber(req.getPhoneNumber(), req.getUsername());
    }

    @GetMapping("/api/v1/users")
    public List<UserView> findAllUsers(@RequestParam(required = false) String username) {
        return userService.findAllUsers();
    }

    @GetMapping(value = "/api/v1/users", params = "username")
    public UserView findUserByUserName(@RequestParam(required = false) String username) {
        return userService.findByUsername(username);
    }

    //회원 정보 변경 ===================================
    @PostMapping("api/v1/users/changeUserPassword")
    public String changeId(@RequestBody ChangeUserPasswordRequest req) {
        return userService.changeUserPassword(req.getUserId(), req.getPassword(), req.getNewPassword());
    }

    @PostMapping("api/v1/users/changePersonalInfo")
    public String changePersonalInfo(@RequestBody User req) {
        return userService.changePersonalInfo(req.getUserId(),req.getPassword(), req.getUsername(), req.getPhoneNumber());
    }

    //회원 정보 삭제 ===================================
    @PostMapping("api/v1/users/deleteUser")
    public String deleteUser(@RequestBody DeleteUserRequest req) {
        return userService.deleteUser(req.getUserId(), req.getPassword());
    }
}
