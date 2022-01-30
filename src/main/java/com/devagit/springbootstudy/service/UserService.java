package com.devagit.springbootstudy.service;

import com.devagit.springbootstudy.domain.user.User;
import com.devagit.springbootstudy.domain.user.UserRequest;
import com.devagit.springbootstudy.domain.user.UserView;
import com.devagit.springbootstudy.handler.UserNotFoundException;
import com.devagit.springbootstudy.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.devagit.springbootstudy.handler.ErrorCode.USER_ID_NOT_THE_SAME;

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
    public UserView login(String userId, String password) {
        User user = userRepository.findByUserId(userId);
        if (user != null){
        throw new UserNotFoundException(USER_ID_NOT_THE_SAME);
        }
        return null;
    }

}





