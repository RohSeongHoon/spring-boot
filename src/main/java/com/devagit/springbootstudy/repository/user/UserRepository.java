package com.devagit.springbootstudy.repository.user;

import com.devagit.springbootstudy.domain.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    List<User> findAll();

    User findByUserId(String userId);

    User findByEmail(String email);

    void deleteByUserId(String userId);

}
