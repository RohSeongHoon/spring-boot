package com.devagit.springbootstudy.controller;


import com.devagit.springbootstudy.request.user.*;
import com.devagit.springbootstudy.service.UserService;
import com.devagit.springbootstudy.util.Page;
import com.devagit.springbootstudy.view.user.DetailProfileView;
import com.devagit.springbootstudy.view.user.UserProfileView;
import com.devagit.springbootstudy.view.user.UserView;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

   //검색필터를 사용할때는 queryDSL을 사용하는것이 맞는지


    //회원 가입  ===================================
    @PostMapping(value = "/api/v1/users")
    public UserView signUp(@RequestBody UserRequest req) {
        return userService.signUp(req.getUserId(), req.getBirthday(), req.getUsername(), req.getPassword(), req.getGender(), req.getEmail(), req.getProfileImg(), req.getIntroduction(), req.getInstarId());
    }

    //로그인 ===================================
    @PostMapping("/api/v1/users/login")
    public String login(@RequestBody LoginRequest req) {
        return userService.login(req.getUserId(), req.getPassword());
    }
    @GetMapping("/api/v1/users/login")
    public String checkToken(@RequestHeader(value = "token")String token,@RequestHeader(value = "refreshToken")String refreshToken, @RequestHeader(value = "expireDate")LocalDateTime expDate){
        return userService.checkToken(token,refreshToken,expDate);
    }


    //회원 정보 조회 ===================================
    @PostMapping("/api/v1/users/find-password") //대쉬
    public String findPasswordByUserId(@RequestBody FindPasswordByUserIdRequest req) {
        return userService.findPasswordByUserId(req.getUserId(), req.getUsername(), req.getEmail());
    }

    @GetMapping("/api/v1/users")
    public List<UserView> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping(value = "/api/v1/users", params = "username")
    public UserView findUserByUserName(@RequestParam(required = false) String username) {
        return userService.findByUsername(username);
    }

    @GetMapping(value = "/api/v1/users", params = "emailDomain")
    public List<UserView> findUserByEmailDomain(@RequestParam(required = false) String emailDomain) {
        return userService.findUserByEmailDomain(emailDomain);
    }

    @GetMapping("/api/v1/profile")
    public Page<UserProfileView> findUserByGender(@RequestParam(required = false) String gender, @Nullable Long age,@Nullable LocalDateTime profileCursor, Pageable pageable) {
        return userService.findUserByGender(gender,age, profileCursor, pageable);
    }

    @GetMapping("/api/v1/{user}/profile")
    public DetailProfileView getDetailProfile(@PathVariable("userId") String userId) {
        return userService.findByUserId(userId);
    }

    //회원 정보 변경 ===================================
    @PutMapping("/api/v1/users/change-userPassword")
    public void changeId(@RequestBody ChangeUserPasswordRequest req) {
        userService.changeUserPassword(req.getUserId(), req.getPassword(), req.getNewPassword());
    }

    @PutMapping("/api/v1/users/chang-personalInfo")
    public void changePersonalInfo(@RequestBody ChangeUserInfoRequest req) {
        userService.changePersonalInfo(req.getUserId(), req.getPassword(), req.getUsername(), req.getEmail(), req.getUpdatedAt());
    }

    //회원 정보 삭제 ===================================
    @DeleteMapping("/api/v1/users")
    public void deleteUser(@RequestBody DeleteUserRequest req) {
        userService.deleteUser(req.getUserId(), req.getPassword());
    }
}
