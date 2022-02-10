package com.devagit.springbootstudy.repository.user;

import com.devagit.springbootstudy.domain.user.User;

import java.util.List;

public interface UserRepository {
    public User save(User user);

    public List<User> findAll();

    public User findByUsername(String username);

    public User findByUserId(String userId);

    public User findByPhoneNumber(String userPhoneNumber);

    public void deleteByUserId(String userId);

}