package com.devagit.springbootstudy.service;

import com.devagit.springbootstudy.domain.User;
import com.devagit.springbootstudy.exceptionHandler.badrequest.UserBadRequestException;
import com.devagit.springbootstudy.exceptionHandler.notfound.UserNotFoundException;
import com.devagit.springbootstudy.view.UserView;
import com.devagit.springbootstudy.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public UserView signUp(String userId, LocalDate birthday, String username, String password, String email, String profileImg, String introduction, String instarId) {
        User user =  User.builder()
                .username(username)
                .birthday(birthday)
                .userId(userId)
                .password(password)
                .email(email)
                .introduction(introduction)
                .profileImg(profileImg)
                .instarId(instarId)
                .build();
        User signUpUser = userRepository.save(user);
        return UserView.from(signUpUser);
    }

    //로그인 ===================================
    public void login(String userId, String password) {
        User user = Optional.ofNullable(userRepository.findByUserId(userId))
                .orElseThrow(() -> new UserBadRequestException("입력하신 정보가 일치하지 않습니다"));
        if (!user.getPassword().equals(password)) {
            throw new UserBadRequestException("입력하신 정보가 일치하지 않습니다");
        }
    }
    //회원 정보 조회 ===================================

    public List<UserView> findAllUsers() {
        return userRepository.findAll().stream().map(UserView::from).collect(Collectors.toList());
    }

    public UserView findByUsername(String username) {
        User user = Optional.ofNullable(userRepository.findByUserId(username))
                .orElseThrow(UserNotFoundException::new);
        return UserView.from(user);
    }


    public String findPasswordByUserId(String userId, String username, String email) {
        User user = Optional.ofNullable(userRepository.findByUserId(userId))
                .orElseThrow(UserNotFoundException::new);
        if (!username.equals(user.getUsername()) && email.equals(user.getEmail())) {
            throw new UserBadRequestException("회원 정보가 일치하지 않습니다");
        }
        String password = blindUserInfo(user.getPassword());
        return password;

    }

    public String findIdByEmail(String email, String username) {
        User user = Optional.ofNullable(userRepository.findByEmail(email))
                .orElseThrow(UserNotFoundException::new);
        if (!email.equals(user.getEmail()) && username.equals(user.getUsername())) {
            throw new UserBadRequestException("회원 정보가 일치하지 않습니다");
        }
        String userId = blindUserInfo(user.getUserId());
        return userId;
    }

    public List<UserView> findUserByEmailDomain(String emailPlatform) {
        return userRepository.findAll()
                .stream()
                .filter(user -> !user.getEmail().equals(null))
                .filter(user -> user.getEmail().contains(emailPlatform))
                .map(UserView::from)
                .collect(Collectors.toList());
    }

    //회원 정보 변경 ===================================
    public void changeUserPassword(String userId, String password, String newPassword) {
        User user = Optional.ofNullable(userRepository.findByUserId(userId))
                .orElseThrow(UserNotFoundException::new);
        if (!user.getPassword().equals(password)) {
            throw new UserBadRequestException("회원정보가 일치하지 않습니다");
        }
        user.setPassword(newPassword);
        userRepository.save(user);
    }

    public void changePersonalInfo(String userId, String password, String username, String email) {
        User user = Optional.ofNullable(userRepository.findByUserId(userId))
                .orElseThrow(UserNotFoundException::new);
        if (!user.getPassword().equals(password)) {
            throw new UserBadRequestException("회원정보가 일치하지 않습니다");
        }
        user.setUsername(username);
        user.setEmail(email);
        userRepository.save(user);

    }
    //회원 정보 삭제 ===================================

    public void deleteUser(String userId, String password) {
        User user = Optional.ofNullable(userRepository.findByUserId(userId))
                .orElseThrow(UserNotFoundException::new);
        if (!user.getPassword().equals(password)) {
            throw  new UserBadRequestException("회원정보가 일치하지 않습니다");
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