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

    public UserView signUp(UserRequest req) {
        User user = new User(req.getUsername(), req.getUserId(), req.getPassword(), req.getPhoneNumber());
        User signUpUser = userRepository.save(user);
        return UserView.from(signUpUser);
    }

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


    public String findPasswordByUserId(String userId, String username, String userPhoneNumber) {
        User user = userRepository.findByUserId(userId);
        if (user.getUsername() != null) {
            if (username.equals(user.getUsername()) && userPhoneNumber.equals(user.getPhoneNumber())) {
                String password = user.getPassword().substring(0, 2);
                for (int i = 0; i < user.getPassword().length() - password.length(); i++) {
                    password += "*";
                }
                return password;
            }
        }
        throw new UserNotFoundException(USER_ID_NOT_THE_SAME);
    }

    public String findIdByUserPhoneNumber(String userPhoneNumber, String username) {
        User user = userRepository.findByUserPhoneNumber(userPhoneNumber);

        throw new UserNotFoundException(USER_PHONE_NUMBER_NOT_THE_SAME);
    }
}





