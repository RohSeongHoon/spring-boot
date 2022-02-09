package com.devagit.springbootstudy.repository;

import com.devagit.springbootstudy.domain.user.User;
import com.devagit.springbootstudy.domain.user.UserRequest;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public User save(User user);

    public List<User> findAll();

    public User findByUsername(String username);

    public User findByUserId(String userId);

    public User findByPhoneNumber(String userPhoneNumber);

    public void deleteByUserId(String userId);

}
