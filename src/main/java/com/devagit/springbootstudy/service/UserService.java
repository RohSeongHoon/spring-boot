package com.devagit.springbootstudy.service;

import com.devagit.springbootstudy.domain.user.User;
import com.devagit.springbootstudy.domain.user.UserRequest;
import com.devagit.springbootstudy.domain.user.UserView;
import com.devagit.springbootstudy.handler.UserNotFoundException;
import com.devagit.springbootstudy.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.devagit.springbootstudy.handler.ErrorCode.*;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //회원 가입 ===================================
    public UserView signUp(UserRequest req) {
        User user = new User(req.getUsername(), req.getUserId(), req.getPassword(), req.getPhoneNumber());
        User signUpUser = userRepository.save(user);
        return UserView.from(signUpUser);
    }

    //로그인 ===================================
    public String login(String userId, String password) {
        User user = userRepository.findByUserId(userId);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return "로그인 성공";
            } else {
                throw new UserNotFoundException(USER_PASSWORD_NOT_THE_SAME);
            }
        }
        throw new UserNotFoundException(USER_ID_NOT_THE_SAME);
    }
    //회원 정보 조회 ===================================

    public List<UserView> findAllUsers() {
        return userRepository.findAll().stream().map(UserView::from).collect(Collectors.toList());
    }

    public UserView findByUsername(String username) throws NullPointerException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new NullPointerException();
        }
        UserView userView = UserView.from(user);
        return userView;
    }


    public String findPasswordByUserId(String userId, String username, String userPhoneNumber) {
        User user = userRepository.findByUserId(userId);
        if (user.getUsername() != null) {
            if (username.equals(user.getUsername()) && userPhoneNumber.equals(user.getPhoneNumber())) {
                String password = userInfoBlind(user.getPassword());
                return password;
            }else{
                throw new UserNotFoundException(USER_INFO_NOT_THE_SAME);
            }
        }
        throw new UserNotFoundException(USER_ID_NOT_THE_SAME);
    }

    public String findIdByPhoneNumber(String phoneNumber, String username) {
        User user = userRepository.findByPhoneNumber(phoneNumber);
        if (user.getPhoneNumber().equals(phoneNumber) && user.getUsername().equals(username)) {
            String userId = userInfoBlind(user.getUserId());
            return userId;
        }
        throw new UserNotFoundException(USER_INFO_NOT_THE_SAME);
    }

    //회원 정보 변경 ===================================
    public String changeUserPassword(String userId, String password, String newPassword) {
        User user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException(USER_ID_NOT_THE_SAME);
        }
        if (user.getPassword().equals(password)) {
            user.setPassword(newPassword);
            userRepository.save(user);
            return "비밀번호 변경 성공";
        }
        throw new UserNotFoundException(USER_PASSWORD_NOT_THE_SAME);
    }
    //회원 정보 삭제 ===================================

    public String deleteUser(String userId, String password) {
        User user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException(USER_ID_NOT_THE_SAME);
        }
        if (user.getPassword().equals(password)) {
            userRepository.deleteByUserId(userId);
            return "삭제 왼료";
        }
        throw new UserNotFoundException(USER_PASSWORD_NOT_THE_SAME);
    }

    //여러 메소드에서 사용되는 기능 ===================================
    public String userInfoBlind(String userInfo) {
        String result = userInfo.substring(0, 2);
        for (int i = 0; i < userInfo.length() - result.length(); i++) {
            result += "*";
        }
        return result;
    }

}





