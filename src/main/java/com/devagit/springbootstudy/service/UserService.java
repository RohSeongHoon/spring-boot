package com.devagit.springbootstudy.service;

import com.devagit.springbootstudy.domain.user.User;
import com.devagit.springbootstudy.view.UserView;
import com.devagit.springbootstudy.exceptionHandler.BusinessException;
import com.devagit.springbootstudy.exceptionHandler.UserNotFoundException;
import com.devagit.springbootstudy.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.devagit.springbootstudy.exceptionHandler.ErrorCode.*;

//로그인 성공이나 비밀번호 완료같은 메시지는 서버에서 전송하지않고 void를 하거나 status를 보내 프론트 쪽에서 관리한다
//모든 로직은 결과가 if문 밖에 있어야한다 만약 안에 있다면 가독성이 떨어지기 때문에 예외를 if문 내부에 넣고 결과는 외부로 뺀다
//optional,steam 검색
//

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //회원 가입 ===================================
    public UserView signUp(String userId, String username, String password, String phoneNumber, String email) {
        User user = new User(userId, username, password, phoneNumber, email);
        User signUpUser = userRepository.save(user);
        return UserView.from(signUpUser);
    }

    //로그인 ===================================
    public String login(String userId, String password) {
        User user = Optional.ofNullable(userRepository.findByUserId(userId))
                .orElseThrow(() -> new UserNotFoundException(USER_ID_NOT_THE_SAME));
        if (!user.getPassword().equals(password)) {
            throw new BusinessException(USER_PASSWORD_NOT_THE_SAME);
        }
        return "로그인 성공";

    }
    //회원 정보 조회 ===================================

    public List<UserView> findAllUsers() {
        return userRepository.findAll().stream().map(UserView::from).collect(Collectors.toList());
    }

    public UserView findByUsername(String username) {
        User user = Optional.ofNullable(userRepository.findByUserId(username))
                .orElseThrow(() -> new UserNotFoundException(USER_INFO_NOT_THE_SAME));
        return UserView.from(user);
    }


    public String findPasswordByUserId(String userId, String username, String userPhoneNumber) {
        User user = Optional.ofNullable(userRepository.findByUserId(userId))
                .orElseThrow(() -> new UserNotFoundException(USER_ID_NOT_THE_SAME));
        if (!username.equals(user.getUsername()) && userPhoneNumber.equals(user.getPhoneNumber())) {
            //equals를 쓸때 주의사항 확인 매개변수로 받는 것은 있다는 가정하에 앞으로 쓴다 국룰
            throw new BusinessException(USER_INFO_NOT_THE_SAME);
        }
        String password = blindUserInfo(user.getPassword());
        return password;

    }

    public String findIdByPhoneNumber(String phoneNumber, String username) {
        User user = Optional.ofNullable(userRepository.findByPhoneNumber(phoneNumber))
                .orElseThrow(() -> new UserNotFoundException(USER_INFO_NOT_THE_SAME));
        if (!user.getPhoneNumber().equals(phoneNumber) && user.getUsername().equals(username)) {
            throw new BusinessException(USER_INFO_NOT_THE_SAME);
        }
        String userId = blindUserInfo(user.getUserId());
        return userId;
    }

    public List<UserView> findUserByEmailPlatform(String emailPlatform) {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getEmail().contains(emailPlatform))
                .map(UserView::from)
                .collect(Collectors.toList());
    }

    //회원 정보 변경 ===================================
    public void changeUserPassword(String userId, String password, String newPassword) {
        User user = Optional.ofNullable(userRepository.findByUserId(userId))
                .orElseThrow(() -> new UserNotFoundException(USER_ID_NOT_THE_SAME));
        if (!user.getPassword().equals(password)) {
            throw new BusinessException(USER_PASSWORD_NOT_THE_SAME);
        }
        user.setPassword(newPassword);
        userRepository.save(user);
    }

    public void changePersonalInfo(String userId, String password, String username, String phoneNumber) {
        User user = Optional.ofNullable(userRepository.findByUserId(userId))
                .orElseThrow(() -> new UserNotFoundException(USER_ID_NOT_THE_SAME));
        if (!user.getPassword().equals(password)) {
            throw new BusinessException(USER_PASSWORD_NOT_THE_SAME);
        }
        user.setUsername(username);
        user.setPhoneNumber(phoneNumber);
        userRepository.save(user);

    }
    //회원 정보 삭제 ===================================

    public void deleteUser(String userId, String password) {
        User user = Optional.ofNullable(userRepository.findByUserId(userId))
                .orElseThrow(() -> new UserNotFoundException(USER_ID_NOT_THE_SAME));
        if (!user.getPassword().equals(password)) {
            throw new BusinessException(USER_PASSWORD_NOT_THE_SAME);
        }
        userRepository.deleteByUserId(userId);
    }//void로 변경


    //여러 메소드에서 사용되는 기능 ===================================
    public String blindUserInfo(String userInfo) { // 메소드명 수정
        String result = userInfo.substring(0, 2);
        for (int i = 0; i < userInfo.length() - result.length(); i++) {
            result += "*";
        }
        return result;
    }


}





