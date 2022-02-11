package com.devagit.springbootstudy.repository.user;

import com.devagit.springbootstudy.domain.user.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    List<User> findAll();

    User findByUsername(String username);

    User findByUserId(String userId);

    User findByPhoneNumber(String userPhoneNumber);

    void deleteByUserId(String userId);

}
